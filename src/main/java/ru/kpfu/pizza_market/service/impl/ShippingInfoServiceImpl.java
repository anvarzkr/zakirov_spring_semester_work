package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.model.ShippingInfo;
import ru.kpfu.pizza_market.repository.ShippingInfoRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.ShippingInfoService;

/**
 * Created by Anvar on 10.05.16.
 */

@Service
public class ShippingInfoServiceImpl implements ShippingInfoService {

    @Autowired
    ShippingInfoRepository shippingInfoRepository;

    @Override
    public void addShippingInfo(String address) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setAddress(address);
        shippingInfo.setUser(AuthProviderImpl.getCurrentUser());

        shippingInfoRepository.save(shippingInfo);
    }

}
