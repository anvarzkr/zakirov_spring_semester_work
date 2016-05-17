package ru.kpfu.pizza_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.OrderItem;

/**
 * Created by Anvar on 11.05.16.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
