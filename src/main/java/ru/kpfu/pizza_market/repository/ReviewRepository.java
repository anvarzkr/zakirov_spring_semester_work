package ru.kpfu.pizza_market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.model.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProduct(Product product);

}
