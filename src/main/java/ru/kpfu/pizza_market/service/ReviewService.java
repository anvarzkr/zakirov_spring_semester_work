package ru.kpfu.pizza_market.service;

import ru.kpfu.pizza_market.form.ReviewForm;
import ru.kpfu.pizza_market.model.Review;


public interface ReviewService {

    Review addReview (ReviewForm reviewForm, Long productId);

}
