package ru.kpfu.pizza_market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.pizza_market.exception.EmailExistsException;
import ru.kpfu.pizza_market.form.UserForm;
import ru.kpfu.pizza_market.model.User;
import ru.kpfu.pizza_market.model.enums.UserRole;
import ru.kpfu.pizza_market.repository.UserRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.UserService;

import static org.springframework.web.util.HtmlUtils.htmlEscape;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void registerUser(UserForm userForm) throws EmailExistsException, IllegalArgumentException {

        if (emailExists(userForm.getEmail())){
            throw new EmailExistsException("User with email \"" + userForm.getEmail() + "\" already exists!");
        }

        if (userForm.getEmail() == null || userForm.getEmail().isEmpty()){
            throw new IllegalArgumentException("email");
        }

        if (userForm.getPassword() == null || userForm.getPassword().isEmpty()){
            throw new IllegalArgumentException("password");
        }

        if (userForm.getFirstName() == null || userForm.getFirstName().isEmpty()){
            throw new IllegalArgumentException("firstName");
        }

        if (userForm.getLastName() == null || userForm.getLastName().isEmpty()){
            throw new IllegalArgumentException("lastName");
        }

        User user = new User();
        user.setEmail(htmlEscape(userForm.getEmail()));
        user.setPassword(encoder.encode(userForm.getPassword()));
        user.setRole(UserRole.ROLE_USER);

        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        userRepository.save(user);
    }

    @Override
    public void updateUser(UserForm userForm) throws IllegalArgumentException {
//        if (userForm.getEmail() == null || userForm.getEmail().isEmpty()){
//            throw new IllegalArgumentException("email");
//        }

        if (userForm.getFirstName() == null || userForm.getFirstName().isEmpty()){
            throw new IllegalArgumentException("firstName");
        }

        if (userForm.getLastName() == null || userForm.getLastName().isEmpty()){
            throw new IllegalArgumentException("lastName");
        }

        User user = AuthProviderImpl.getCurrentUser();

//        user.setEmail(htmlEscape(userForm.getEmail()));

        if (userForm.getPassword() != null && !userForm.getPassword().isEmpty())
            user.setPassword(encoder.encode(userForm.getPassword()));

        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        userRepository.save(user);
    }

    @Override
    public boolean emailExists(String email) {
        userRepository.findOneByEmail(email);
        return userRepository.findOneByEmail(email) != null;
    }
}


