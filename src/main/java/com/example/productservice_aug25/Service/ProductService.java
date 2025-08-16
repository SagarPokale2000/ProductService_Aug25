package com.example.productservice_aug25.Service;

import com.example.productservice_aug25.Models.Product;

import java.util.List;

public interface ProductService  {

    List<Product> getAllProducts();

    Product getSingleProductById(Long productId);

    Product createProduct(Product product);

    Product replaceProduct(Long productId, Product product);
}
