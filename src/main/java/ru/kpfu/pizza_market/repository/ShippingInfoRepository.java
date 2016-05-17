package ru.kpfu.pizza_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.ShippingInfo;
import ru.kpfu.pizza_market.model.User;

import java.util.List;

/**
 * Created by Anvar on 10.05.16.
 */

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {

    List<ShippingInfo> findAllByUser(User user);

}
