package ru.kpfu.pizza_market.service;

import ru.kpfu.pizza_market.model.Product;

/**
 * Created by Anvar on 11.05.16.
 */
public interface OrderItemService {

    void addOrderItem(Product product, Integer quantity, Integer price);

}
