package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.form.ReviewForm;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.model.Review;
import ru.kpfu.pizza_market.repository.CategoryRepository;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.repository.ReviewRepository;
import ru.kpfu.pizza_market.service.ProductService;

import java.util.List;


@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productsPage(@RequestParam(value = "filter", required = false) String filter, Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Product> productsAll;
        List<Product> productsBestsellers = productRepository.findTop10ByOrderBySalesCountDesc();
        List<Product> productsLatest = productRepository.findTop10ByOrderByCreatedAtDesc();

        if (filter != null){
            switch (filter){
                case "price_down":
                    productsAll = productRepository.findAllByOrderByPriceDesc();
                    break;
                case "name_up":
                    productsAll = productRepository.findAllByOrderByNameAsc();
                    break;
                case "name_down":
                    productsAll = productRepository.findAllByOrderByNameDesc();
                    break;
                case "price_up":
                default:
                    productsAll = productRepository.findAllByOrderByPriceAsc();
                    break;
            }
        }else{
            productsAll = productRepository.findAllByOrderByPriceAsc();
            filter = "price_up";
        }

        model.addAttribute("products", productsAll);
        model.addAttribute("productsBestsellers", productsBestsellers);
        model.addAttribute("productsLatest", productsLatest);
        model.addAttribute("filter", filter);
        return "products";
    }

    @RequestMapping(value = "/categories/{category_id}", method = RequestMethod.GET)
    public String categoryProductsPage(@PathVariable("category_id") Long categoryId, Model model) {
        Category category = categoryRepository.findOne(categoryId);
        List<Product> products = productRepository.findAllByCategory(category);
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        return "category-products";
    }

    @RequestMapping(value = "/products/{product_id}", method = RequestMethod.GET)
    public String singleProductPage(@PathVariable("product_id") Long productId,
                                    @RequestParam(value = "review_sent", required = false) Boolean reviewSent,
                                    Model model) {
        Product product = productRepository.findOne(productId);
        model.addAttribute("product", product);
        List<Review> reviews = reviewRepository.findAllByProduct(product);
        model.addAttribute("reviews", reviews);
        model.addAttribute("reviews_count", reviews.size());
        ReviewForm reviewForm = new ReviewForm();
        model.addAttribute("reviewForm", reviewForm);

        if (Boolean.TRUE.equals(reviewSent))
            model.addAttribute("review_sent", reviewSent);

        return "product-single";
    }

}
