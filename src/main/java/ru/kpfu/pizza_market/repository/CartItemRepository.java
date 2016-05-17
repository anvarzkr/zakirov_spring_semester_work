package ru.kpfu.pizza_market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.CartItem;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.model.User;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findOneByProduct(Product product);

    List<CartItem> findAllByUser(User user);

    CartItem findOneByProductAndUser(Product product, User user);

}
