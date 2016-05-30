package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.client.service.GwtService;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.repository.CategoryRepository;

import java.util.List;

/**
 * Created by Anvar on 12.05.16.
 */

@Service("gwtService")
public class GwtServiceImpl implements GwtService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
