package ru.kpfu.pizza_market.service;

import ru.kpfu.pizza_market.exception.EmailExistsException;
import ru.kpfu.pizza_market.form.UserForm;
import ru.kpfu.pizza_market.model.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAllByCategoryId(Long categoryId);

}
