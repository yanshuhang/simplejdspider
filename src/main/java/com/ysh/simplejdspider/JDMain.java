package com.ysh.simplejdspider;

import com.ysh.simplejdspider.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class JDMain implements CommandLineRunner {
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        bookService.getInfo();
    }
}
