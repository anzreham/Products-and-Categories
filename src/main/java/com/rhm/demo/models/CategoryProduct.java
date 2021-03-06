package com.rhm.demo.models;
import java.util.Date;
import javax.persistence.*;
// ...
@Entity
@Table(name="categories_products")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public CategoryProduct() {

    }

    public CategoryProduct(Long id, Date createdAt, Date updatedAt, Product product, Category category) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.product = product;
        this.category = category;
    }

    public CategoryProduct(Date createdAt, Date updatedAt, Product product, Category category) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.product = product;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
// ...
    // getters and setters removed for brevity
    // ...
}
