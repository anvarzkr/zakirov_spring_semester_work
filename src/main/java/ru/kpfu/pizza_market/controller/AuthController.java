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
import ru.kpfu.pizza_market.model.ShippingInfo;
import ru.kpfu.pizza_market.model.User;
import ru.kpfu.pizza_market.repository.ShippingInfoRepository;
import ru.kpfu.pizza_market.security.AuthProviderImpl;
import ru.kpfu.pizza_market.service.UserService;

import java.util.List;

/**
 * Created by Anvar on 06.05.16.
 */

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    ShippingInfoRepository shippingInfoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(){
        return "index";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String signInPage(@RequestParam(value = "error", required = false) Boolean error,
                            Model model){
        if (Boolean.TRUE.equals(error)){
            model.addAttribute("error", error);
        }
        return "/sign_in";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settingsPage(@RequestParam(value = "changed", required = false) Boolean changedSettings, Model model){
        User currentUser = AuthProviderImpl.getCurrentUser();
        UserForm userForm = new UserForm(currentUser.getEmail(), currentUser.getFirstName(), currentUser.getLastName());
        model.addAttribute("userForm", userForm);

        List<ShippingInfo> shippingInfoList = shippingInfoRepository.findAllByUser(AuthProviderImpl.getCurrentUser());
        model.addAttribute("shipping_info_list", shippingInfoList);

        if (Boolean.TRUE.equals(changedSettings))
            model.addAttribute("changed", changedSettings);

        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String settingsChange(@ModelAttribute("userForm") UserForm userForm, BindingResult result){

        if (!result.hasErrors()){
            try {
                userService.updateUser(userForm);
            }catch (IllegalArgumentException illegalArgumentException){
                System.err.println(illegalArgumentException.getMessage());
                String fieldName;
                switch (illegalArgumentException.getMessage()){
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
                return "settings";
            }
        }

        return "redirect:/settings?changed=true";
    }

}
