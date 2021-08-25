package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.exeptions.UserAlreadyExistException;
import com.goIt.ProductManagement.model.dto.UserDTO;
import com.goIt.ProductManagement.model.entity.User;
import com.goIt.ProductManagement.model.enums.UserRole;
import com.goIt.ProductManagement.model.service.RoleService;
import com.goIt.ProductManagement.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Controller
@RequestMapping(path = "/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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

    @ModelAttribute("userForm")
    public UserDTO defaultUserDTO() {
        return new UserDTO();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "index")
    public String ShowUserIndexPage(Model model) {
        LOG.info("showUsersPage.");
        Set<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/update")
    public String ShowUpdateUserPage(@RequestParam(name = "id") UUID id, Model model) {
        List<UserRole> roles = (Arrays.asList(UserRole.values()));
        UserDTO user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "userDetails";

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/update")
    public RedirectView update(@ModelAttribute("user") UserDTO user) {
        userService.update(user);
        return new RedirectView("index");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam(name = "id") UUID id) {
        userService.delete(id);
        return new RedirectView("index");
    }
}
