package com.qihong.demowebflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebFluxConfig {

    @Bean
    public RouterFunction<ServerResponse>hello(){
        Mono<String>monoStr=Mono.fromSupplier(() -> "123");

        return RouterFunctions.route().GET("/hello",serverRequest -> ServerResponse.ok().body(monoStr,String.class)).build();
    }

}
