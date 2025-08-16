package com.example.productservice_aug25.Controller;

import com.example.productservice_aug25.Models.Product;
import com.example.productservice_aug25.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//localhost:8080/products
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product GetProductDetails(@PathVariable Long productId)
    {
        return productService.getSingleProductById(productId);
    }

//    http://localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts()
    {
        return new ArrayList<>();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return null;
    }

    @PutMapping("/{productId}")
    public Product replaceProduct(@PathVariable Long productId, @RequestBody Product product)
    {
        return null;
    }
}
