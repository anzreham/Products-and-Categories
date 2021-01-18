package com.rhm.demo.repositories;

import com.rhm.demo.models.Category;
import com.rhm.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    void deleteById(Long id);
    List<Product> findByCategoriesNotContains(Category category);
}