package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.model.CartItem;
import ru.kpfu.pizza_market.model.ShippingInfo;
import ru.kpfu.pizza_market.repository.CartItemRepository;
import ru.kpfu.pizza_market.repository.ShippingInfoRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.CartItemService;

import java.util.List;

/**
 * Created by Anvar on
 *
 * @09.05.16.
 */

@Controller
public class CartController {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    ShippingInfoRepository shippingInfoRepository;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartPage(Model model){
        List<CartItem> cartItems = cartItemRepository.findAllByUser(AuthProviderImpl.getCurrentUser());
        int overallSum = 0;
        for (CartItem cartItem : cartItems)
            overallSum += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        model.addAttribute("cart_items", cartItems);
        model.addAttribute("overall_sum", overallSum);

        List<ShippingInfo> shippingInfoList = shippingInfoRepository.findAllByUser(AuthProviderImpl.getCurrentUser());
        model.addAttribute("shipping_info_list", shippingInfoList);

        return "cart";
    }

    @RequestMapping(value = "/cart/remove/{cart_item_id}", method = RequestMethod.POST)
    public String removeCartItem(@PathVariable("cart_item_id") Long cartItemId){

        cartItemRepository.delete(cartItemId);

        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/add/{product_id}", method = RequestMethod.POST)
    public String addCartItem(@PathVariable("product_id") Long product_id, @RequestParam(value = "quantity", required = false) Integer quantity){

        cartItemService.addCartItem(product_id, quantity);

        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/change_quantity/{cart_item_id}", method = RequestMethod.POST)
    public String changeQuantityOfCartItem(@PathVariable("cart_item_id") Long cartItemId, @RequestParam(value = "quantity", required = false) Integer quantity){

        cartItemService.changeQuantity(cartItemId, quantity);

        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart/order", method = RequestMethod.POST)
    public String addOrder(@RequestParam("shipping_info_id") Long shippingInfoId){
        return "redirect:/orders";
    }

}
