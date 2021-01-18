package com.rhm.demo.repositories;

import java.util.List;

import com.rhm.demo.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryProductRepoistory extends CrudRepository<CategoryProduct, Long>{
    //SELECT * FROM DLs
    List<CategoryProduct> findAll();
}