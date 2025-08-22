package com.example.productservice_aug25.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModal {
    private String title;
    private String description;
    private Double price;
    private String imgUrl;

    @ManyToOne
    private Category category;
}

// 1         1
//Product Category
// M         1
