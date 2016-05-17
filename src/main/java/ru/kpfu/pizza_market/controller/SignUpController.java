package ru.kpfu.pizza_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.pizza_market.exception.EmailExistsException;
import ru.kpfu.pizza_market.form.UserForm;
import ru.kpfu.pizza_market.service.UserService;

/**
 * Created by Anvar on 06.05.16.
 */

@Controller
public class SignUpController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String signInPage(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "/sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String SignUpProcess(@ModelAttribute("userForm") UserForm userForm, BindingResult result){

        boolean registered = false;

        if (!result.hasErrors()){
            try {
                userService.registerUser(userForm);
            }catch (EmailExistsException emailExistsException){
                result.rejectValue("email", "", "Email already exists!");
            }catch (IllegalArgumentException illegalArgumentException){
                System.err.println(illegalArgumentException.getMessage());
                String fieldName;
                switch (illegalArgumentException.getMessage()){
                    case "email":
                        fieldName = "Email";
                        break;
                    case "password":
                        fieldName = "Password";
                        break;
                    case "firstName":
                        fieldName = "First Name";
                        break;
                    case "lastName":
                        fieldName = "Last Name";
                        break;
                    default:
                        fieldName = "Undefined";
                }
                result.rejectValue(illegalArgumentException.getMessage(), "", fieldName + " field can't be blank!");
            }
        }

        if (result.hasErrors()){
            return "sign_up";
        }else {
            return "redirect:/sign_in";
        }

    }

}