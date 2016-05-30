package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.form.ProductForm;
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

    @Override
    public Product save(ProductForm productForm) {
        System.out.println(productForm.getName());
        System.out.println(productForm.getCategoryId());
        System.out.println(productForm.getDescription());
        System.out.println(productForm.getDiameterSize());
        System.out.println(productForm.getImg());
        System.out.println(productForm.getPrice());
        System.out.println(productForm.getWeight());

        Product product = new Product();

        Category category = categoryRepository.findOne(productForm.getCategoryId());

        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setDescription(productForm.getDescription());
        product.setCategory(category);
        product.setDiameterSize(productForm.getDiameterSize());
        product.setWeight(productForm.getWeight());
        product.setImg(productForm.getImg());

        return productRepository.save(product);
    }

}
