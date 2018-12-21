package com.qh.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    public static ThreadLocal<Map<String,Object>> threadLocal =new ThreadLocal<Map<String,Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String,Object>();
        }
    };
    @Pointcut(value="@annotation(log)")
    public void logMethod(Log log){

    }
    @Before("logMethod(log)")
    public void deBefore(JoinPoint joinPoint,Log log) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("IP : " + request.getRemoteAddr());
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "logMethod(log)")
    public void doAfterReturning(Object ret,Log log) throws Throwable {
        // 处理完请求，返回内容
        logger.info("方法的返回值 : " + ret);
        logger.info("action : " + log.action());
        logger.info("desc : " + log.desc());
        logger.info("uuid : " + LogAspect.threadLocal.get().get("uuid"));
        LogAspect.threadLocal.get().put("uuid","");
    }

    //后置异常通知
    @AfterThrowing("logMethod(log)")
    public void throwss(JoinPoint jp,Log log){
        System.out.println("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("logMethod(log)")
    public void after(JoinPoint jp,Log log){
        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("logMethod(log)")
//    public Object arround(ProceedingJoinPoint pjp,Log log) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//    }
}
