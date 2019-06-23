package com.ysh.simplejdspider.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    private int id;
    private String name;
    private BigDecimal price;
    private String pictureUrl;
}
