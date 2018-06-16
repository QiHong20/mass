package com.example.demomultisourceofmybatis.mapper2;


import com.example.demomultisourceofmybatis.entity.UserPass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactionManager2")
public interface UserPassMapper {

    @Select("select user,password from user_pass where user = #{user}")
    UserPass getByUser(String user);

    @Update("update user_pass set password =#{password} where user = #{user}")
    void update(@Param("user") String user,@Param("password") String password);
}
