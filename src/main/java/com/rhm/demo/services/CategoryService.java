package com.rhm.demo.services;
import com.rhm.demo.models.Category;
import com.rhm.demo.models.Product;
import com.rhm.demo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }

    public Category getCategory ( Long id){
        return this.categoryRepository.findById(id).orElse(null);
    }

    public  Category creatCategory ( Category category){
        return  this.categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }

    //Delete a product from Category
    public Category deleteProductFromCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> findByProductsNotContains(Product product) {
        return this.categoryRepository.findByProductsNotContains(product);
    }

}







