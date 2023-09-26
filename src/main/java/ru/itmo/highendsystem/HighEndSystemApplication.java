package ru.itmo.highendsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass= true )
@SpringBootApplication
public class HighEndSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighEndSystemApplication.class, args);
    }

}
