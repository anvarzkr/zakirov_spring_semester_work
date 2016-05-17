package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.service.OrderService;

/**
 * Created by Anvar on 10.05.16.
 */

@Controller
public class OrdersController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String ordersPage(Model model){
        return "orders";
    }

    @RequestMapping(value = "/order/checkout", method = RequestMethod.POST)
    public String orderCheckout(@RequestParam("shipping_info_id") Long shippingInfoId){



        return "redirect:/orders";
    }

}
