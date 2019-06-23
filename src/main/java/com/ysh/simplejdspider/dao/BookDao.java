package com.ysh.simplejdspider.dao;

import com.ysh.simplejdspider.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    int addBook(Book book);

    void addBooks(List<Book> bookList);

    Book selectBook(int id);
}
