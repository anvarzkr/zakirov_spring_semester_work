package ru.kpfu.pizza_market.service;

import ru.kpfu.pizza_market.model.CartItem;

/**
 * Created by Anvar on 09.05.16.
 */
public interface CartItemService {

    CartItem addCartItem(Long productId, Integer quantity);

    CartItem changeQuantity(Long cartItemId, Integer quantity);

}
