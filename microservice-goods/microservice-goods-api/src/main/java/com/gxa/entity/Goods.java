package com.gxa.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer id;
    private String name;
    private Double price;

    private Shop shop;
}

