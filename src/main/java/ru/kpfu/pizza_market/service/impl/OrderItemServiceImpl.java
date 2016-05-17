package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.model.OrderItem;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.repository.OrderItemRepository;
import ru.kpfu.pizza_market.service.OrderItemService;

/**
 * Created by Anvar on 11.05.16.
 */

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public void addOrderItem(Product product, Integer quantity, Integer price) {

        OrderItem orderItem = new OrderItem();

        if (product == null)
            return;
        orderItem.setProduct(product);

        if (quantity == null || quantity < 1)
            quantity = 1;
        orderItem.setQuantity(quantity);

        orderItem.setPrice( (price == null || price < 0) ? product.getPrice() * quantity : price);

        orderItemRepository.save(orderItem);
    }

}
