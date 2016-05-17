package ru.kpfu.pizza_market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.pizza_market.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Поиск пользователя по электронной почте
     * @param login
     * @return
     */

    User findOneByEmail(String login);

}
