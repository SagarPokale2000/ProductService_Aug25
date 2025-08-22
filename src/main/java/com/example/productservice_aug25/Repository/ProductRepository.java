package com.example.productservice_aug25.Repository;

import com.example.productservice_aug25.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Declared Quaries
    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    List<Product> findByTitle(String title);

    List<Product> findByTitleContainsIgnoreCase(String title);

    List<Product> findByPriceBetween(Double priceStart, Double priceEnd);

    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(String title, Double priceStart, Double priceEnd);

    void deleteById(Long id);

    Product save(Product product);

    //HQL
//    @Query("")
}
