package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.repository.CategoryRepository;
import ru.kpfu.pizza_market.service.impl.ProductServiceImpl;

/**
 * Created by Anvar on 12.05.16.
 */

@Controller
public class AdminController {

    @Autowired
    private ProductServiceImpl itemService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String pageRender() {
        return "admin_gwt";
    }

    @RequestMapping(value = "/admin/html", method = RequestMethod.GET)
    public String gwtAdmin() {
        return "admin_gwt";
    }

    @RequestMapping(value = "/admin/add_category", method = RequestMethod.POST)
    public String addCategory(@RequestParam("name") String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "admin_gwt";
    }

    @RequestMapping(value = "/admin/add_item", method = RequestMethod.POST)
    public String addItem(@RequestParam("name") String name, @RequestParam("price") int price,
                          @RequestParam("description") String descript, @RequestParam("category") long categorID,
                          @RequestParam("count") int count) {
//        Item item = new Item(name);
//        item.setRecom(1);
//        item.setPrice(Double.valueOf(price));
//        item.setDescription(descript);
//        item.setCategory(categoryService.getByID(categorID));
//        item.setCount(count);
//        itemService.add(item);
        return "admin_gwt";
    }
}
