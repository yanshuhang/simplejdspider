package com.ysh.simplejdspider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ysh.simplejdspider.dao")
public class SimplejdspiderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimplejdspiderApplication.class, args);
    }

}
