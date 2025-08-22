package com.example.productservice_aug25.Controller;

import com.example.productservice_aug25.Exception.ProductNotFoundException;
import com.example.productservice_aug25.Models.Product;
import com.example.productservice_aug25.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//localhost:8080/products
@RestController
@RequestMapping("/products")
public class  ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("dbProductServices") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> GetProductDetails(@PathVariable Long productId)
    {
        try {
            Product p = productService.getSingleProductById(productId);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch (ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    http://localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        try {
            Product p = productService.createProduct(product);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productId}")
    public Product replaceProduct(@PathVariable Long productId, @RequestBody Product product)
    {
        return null;
    }
}
