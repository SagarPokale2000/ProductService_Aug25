package com.example.productservice_aug25.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModal {
    private String title;
    private String description;
    private Double price;
    private String imgUrl;
    private Category category;
}
