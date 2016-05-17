package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.repository.ShippingInfoRepository;
import ru.kpfu.pizza_market.service.ShippingInfoService;

/**
 * Created by Anvar on 10.05.16.
 */

@Controller
public class ShippingInfoController {

    @Autowired
    ShippingInfoService shippingInfoService;

    @Autowired
    ShippingInfoRepository shippingInfoRepository;

    @RequestMapping(value = "/shipping_info/add", method = RequestMethod.POST)
    public String addShippingInfo(@RequestParam("address") String address){

        shippingInfoService.addShippingInfo(address);

        return "redirect:/settings";
    }

    @RequestMapping(value = "/shipping_info/remove", method = RequestMethod.POST)
    public String removeShippingInfo(@RequestParam("shipping_info_id") Long shippingInfoId){

        shippingInfoRepository.delete(shippingInfoId);

        return "redirect:/settings";
    }

}
