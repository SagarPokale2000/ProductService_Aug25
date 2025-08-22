package com.example.productservice_aug25.Repository;

import com.example.productservice_aug25.Models.Category;
import com.mysql.cj.callback.OpenidConnectIdTokenFromFileCallbackHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByTitle(String title);

    Category save(Category category);

}
