package com.rhm.demo.services;

import com.rhm.demo.models.Category;
import com.rhm.demo.models.Product;
import com.rhm.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
     public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product getproduct ( Long id){
       return this.productRepository.findById(id).orElse(null);
    }

    public  Product creatProduct ( Product product){
        return  this.productRepository.save(product);
    }

    public List<Product> findByCategoriesNotContains(Category category) {
        return this.productRepository.findByCategoriesNotContains(category);
    }

    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    //Delete a product from Category
    public Product deleteProductFromCategory(Product product) {
        return this.productRepository.save(product);
    }

    public void addCategoryToProduct(Product product, Category category) {
        List<Category> categories = product.getCategories();
        categories.add(category);
        this.productRepository.save(product);
    }

}







