package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.pizza_market.form.ReviewForm;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.repository.ReviewRepository;
import ru.kpfu.pizza_market.service.ReviewService;

/**
 * Created by Anvar on 08.05.16.
 */

@Controller
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/review/add/{product_id}", method = RequestMethod.POST)
    public String sendReview(@ModelAttribute("reviewForm") ReviewForm reviewForm,
                             @PathVariable("product_id") Long productId,
                             Model model){

        reviewService.addReview(reviewForm, productId);

        return "redirect:/products/" + productId + "?review_sent=true";
    }

}
