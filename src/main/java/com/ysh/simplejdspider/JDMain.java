package com.ysh.simplejdspider;

import com.ysh.simplejdspider.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class JDMain implements CommandLineRunner {
    private final BookService bookService;

    public JDMain(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.getInfo();
    }
}
