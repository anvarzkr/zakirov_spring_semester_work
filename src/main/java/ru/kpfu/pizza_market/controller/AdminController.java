package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.form.ProductForm;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.repository.CategoryRepository;
import ru.kpfu.pizza_market.service.impl.ProductServiceImpl;

/**
 * Created by Anvar on 12.05.16.
 */

@Controller
public class AdminController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String pageRender() {
        return "admin_gwt";
    }

    @RequestMapping(value = "/admin/add_category", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "admin_gwt";
    }

    @RequestMapping(value = "/admin/add_product", method = RequestMethod.POST)
    public String addProduct(@RequestParam("name") String name, @RequestParam("price") Integer price,
                          @RequestParam("weight") Integer weight,  @RequestParam("diameter_size") Integer diameterSize,
                          @RequestParam("description") String description, @RequestParam("img") String img,
                          @RequestParam("category_id") Long categoryId) {

        ProductForm productForm = new ProductForm(name, description, price, weight, diameterSize, img, categoryId);

        productService.save(productForm);

        return "admin_gwt";
    }
}
