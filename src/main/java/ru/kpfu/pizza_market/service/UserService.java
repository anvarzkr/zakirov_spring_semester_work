package ru.kpfu.pizza_market.service;

import ru.kpfu.pizza_market.exception.EmailExistsException;
import ru.kpfu.pizza_market.form.UserForm;


public interface UserService {

    void registerUser(UserForm userForm) throws EmailExistsException, IllegalArgumentException;

    void updateUser(UserForm userForm);

    boolean emailExists(String login);
}
