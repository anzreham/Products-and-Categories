package com.rhm.demo.services;

import com.rhm.demo.models.CategoryProduct;
import com.rhm.demo.repositories.CategoryProductRepoistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductService {
    private CategoryProductRepoistory categoryProductRepoistory;

    public CategoryProductService(CategoryProductRepoistory categoryProductRepoistory) {
        this.categoryProductRepoistory = categoryProductRepoistory;
    }


    public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {
        return this.categoryProductRepoistory.save(categoryProduct);
    }

    public List<CategoryProduct> findAllCategoryProduct() {
        return this.categoryProductRepoistory.findAll();
    }


    public void deleteById(Long id) {
        this.categoryProductRepoistory.deleteById(id);
    }

}