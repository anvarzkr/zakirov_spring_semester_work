package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.model.Product;
import ru.kpfu.pizza_market.repository.CategoryRepository;
import ru.kpfu.pizza_market.repository.ProductRepository;
import ru.kpfu.pizza_market.service.ProductService;

import java.util.List;

/**
 * Created by Anvar on 08.05.16.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        return productRepository.findAllByCategory(category);
    }
}
