package ru.kpfu.pizza_market.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.repository.ReviewRepository;

/**
 * Created by Anvar on 08.05.16.
 */

@Controller
public class ReviewApiController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/api/review/get/{review_id}", method = RequestMethod.GET)
    public String getReview(@PathVariable("review_id") Long reviewId, Model model){
        model.addAttribute("review", reviewRepository.findOne(reviewId));
        return "product-review-item";
    }

//    @RequestMapping(value = "/api/review/send/{product_id}", method = RequestMethod.POST)
//    public String sendReview(@RequestParam("text") String text,
//                             @RequestParam("rating") Integer rating,
//                             @PathVariable("product_id") Long productId,
//                             Model model){
//
//        Product product = productRepository.findOne(productId);
//
//        return "product-review-item";
//    }

}
