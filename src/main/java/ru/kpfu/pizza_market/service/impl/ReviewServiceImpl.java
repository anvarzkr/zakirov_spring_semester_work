package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.form.ReviewForm;
import ru.kpfu.pizza_market.model.Review;
import ru.kpfu.pizza_market.model.User;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.repository.ReviewRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.ReviewService;

import java.util.Date;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review addReview(ReviewForm reviewForm, Long productId) {
        Review review = new Review();
        review.setText(reviewForm.getText());
        review.setCreatedAt(new Date());
        review.setProduct(productRepository.findOne(productId));
        review.setRating(reviewForm.getRating());
        review.setUser(AuthProviderImpl.getCurrentUser());
        return reviewRepository.save(review);
    }

}


