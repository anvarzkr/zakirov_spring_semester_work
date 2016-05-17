package ru.kpfu.pizza_market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Поиск категории по названию
     * @param name
     * @return
     */

    Category findOneByName(String name);

}
