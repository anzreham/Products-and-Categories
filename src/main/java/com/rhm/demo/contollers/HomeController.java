package com.rhm.demo.contollers;

import com.rhm.demo.models.Category;
import com.rhm.demo.models.CategoryProduct;
import com.rhm.demo.models.Product;
import com.rhm.demo.repositories.CategoryRepository;
import com.rhm.demo.services.CategoryProductService;
import com.rhm.demo.services.CategoryService;
import com.rhm.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    CategoryProductService categoryProductService;
    //private  productCategoryService;


    public HomeController(ProductService productService, CategoryService categoryService, CategoryProductService categoryProductService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.categoryProductService = categoryProductService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = this.productService.getAll();
        model.addAttribute("products", products);

        List<Category> categories = this.categoryService.getAll();
        model.addAttribute("categories", categories);

        return "home";
    }
// to create a new product :
    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {

        return "newProduct";
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()) {
            return "newProduct";
        }
        this.productService.creatProduct(product);
        return "redirect:/";
    }
// to create a new category :
    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {

        return "newCategory";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "newCategory";
        }
        else {
            categoryService.creatCategory(category);
            return "redirect:/";
        }
    }


    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, @ModelAttribute("categoryProduct")  CategoryProduct CatPro, Model model) {


        Product product = this.productService.getproduct(id);
        model.addAttribute("product", product);
        List<Category> categories = product.getCategories();
        List<Category> CategoriesnotContain = categoryService.findByProductsNotContains(product);
        model.addAttribute("categories", categories);
        model.addAttribute("CategoriesNotContainPro", CategoriesnotContain);

        return "showProduct";
    }


    @GetMapping("/categories/{id}")
    public String showCategory(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("categoryProduct")  CategoryProduct CatPro, Model model) {
        Category category = this.categoryService.getCategory(id);
        model.addAttribute("category", category);
        List<Product> products = category.getProducts();
        List<Product> ProducysNotContainCat = this.productService.findByCategoriesNotContains(category);
        model.addAttribute("allProducts", products);
        model.addAttribute("ProducysNotContainCat", ProducysNotContainCat);

        return "showCategory";
    }

//add Category to product
    @RequestMapping(value = "/products/addCatTopro", method = RequestMethod.POST)
    public String createCategoryProduct(@ModelAttribute("categoryProduct") CategoryProduct categoryProduct , BindingResult result) {
        if(result.hasErrors()) {
            return "showProduct";
        }
        else {
            categoryProductService.createCategoryProduct(categoryProduct);
            return "redirect:/";
        }
    }



}





























