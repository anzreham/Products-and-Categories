package com.rhm.demo.repositories;

import java.util.List;

import com.rhm.demo.models.Category;
import com.rhm.demo.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    List<Category> findAll();


    List<Category> findByProductsNotContains(Product product);

}