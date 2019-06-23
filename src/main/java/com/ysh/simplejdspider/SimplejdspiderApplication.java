package com.ysh.simplejdspider;

import com.ysh.simplejdspider.service.BookService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.ysh.simplejdspider.dao")
public class SimplejdspiderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimplejdspiderApplication.class, args);
    }

}
