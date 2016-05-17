package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.model.CartItem;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.model.User;
import ru.kpfu.pizza_market.repository.CartItemRepository;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.CartItemService;

/**
 * Created by Anvar on 09.05.16.
 */

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public CartItem addCartItem(Long productId, Integer quantity) {
        User currentUser = AuthProviderImpl.getCurrentUser();
        if (currentUser == null)
            return null;

        Product product = productRepository.findOne(productId);
        if (product == null)
            return null;

        CartItem cartItem = cartItemRepository.findOneByProductAndUser(product, currentUser);

        if (quantity == null || quantity < 1)
            quantity = 1;

        if (cartItem != null){
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setUser(currentUser);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
        }

        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem changeQuantity(Long cartItemId, Integer quantity) {

        CartItem cartItem = cartItemRepository.findOne(cartItemId);

        if (cartItem == null)
            return null;

        if (quantity == null || quantity < 1)
            return null;

        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);

    }

}
