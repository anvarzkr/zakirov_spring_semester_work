package ru.kpfu.pizza_market.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.Order;

/**
 * Created by Anvar on 11.05.16.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
