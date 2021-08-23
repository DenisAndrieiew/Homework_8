package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.exeptions.UserAlreadyExistException;
import com.goIt.ProductManagement.model.Service.UserService;
import com.goIt.ProductManagement.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(path = "user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("registration")
    public String register(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        try {
            userService.register(user);
        } catch (UserAlreadyExistException ex) {
            model.addAttribute("message", "Account with provided email already exists");
            return "registration";
        }

        return "redirect:/login";
    }

    @ModelAttribute("userForm")
    public User defaultUser() {
        return new User();
    }
}
