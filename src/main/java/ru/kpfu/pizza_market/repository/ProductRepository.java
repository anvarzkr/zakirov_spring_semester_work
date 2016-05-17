package ru.kpfu.pizza_market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.Category;
import ru.kpfu.pizza_market.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Поиск товара по названию
     * @param name
     * @return
     */

    Product findOneByName(String name);

    List<Product> findAllByCategory(Category category);

//    List<Product> findAllByPrice(Integer price);

//    List<Product> findAllBetweenFromPriceAndToPriceOrderByPrice(Integer fromPrice, Integer toPrice);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByNameDesc();

    List<Product> findAllByOrderByNameAsc();


//    List<Product> findTop10ByOrderByPriceAscCreatedAtDesc();
//
//    List<Product> findTop10ByOrderByPriceAscSalesCountDesc();
//
//
//    List<Product> findTop10ByOrderByPriceDescCreatedAtDesc();
//
//    List<Product> findTop10ByOrderByPriceDescSalesCountDesc();
//
//
//    List<Product> findTop10ByOrderByNameAscCreatedAtDesc();
//
//    List<Product> findTop10ByOrderByNameAscSalesCountDesc();
//
//
//    List<Product> findTop10ByOrderByNameDescCreatedAtDesc();
//
//    List<Product> findTop10ByOrderByNameDescSalesCountDesc();


//    List<Product> findAllByOrderByCreatedAtDesc();

    List<Product> findTop10ByOrderByCreatedAtDesc();

//    List<Product> findAllByOrderBySalesCountDesc();

    List<Product> findTop10ByOrderBySalesCountDesc();

}
