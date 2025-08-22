package com.example.productservice_aug25.Service;

import com.example.productservice_aug25.Exception.ProductNotFoundException;
import com.example.productservice_aug25.Models.Category;
import com.example.productservice_aug25.Models.Product;
import com.example.productservice_aug25.Repository.CategoryRepository;
import com.example.productservice_aug25.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductServices")
/*OR
@Primary*/
public class DBProductServices implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DBProductServices(ProductRepository productRepository,  CategoryRepository categoryRepository ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProductById(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);

        if(product.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }

        return product.get();
    }

    @Override
    public Product createProduct(Product product) {

        Category category = product.getCategory();

        Optional<Category> categoryOpt = categoryRepository.findByTitle(category.getTitle());

        if(categoryOpt.isEmpty()){
            //Create a category
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        else{
            product.setCategory(categoryOpt.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }
}
