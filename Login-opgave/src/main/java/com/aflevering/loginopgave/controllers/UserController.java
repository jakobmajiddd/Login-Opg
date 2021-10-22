package com.aflevering.loginopgave.controllers;

import com.aflevering.loginopgave.models.User;
import com.aflevering.loginopgave.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserService userServicve;

    @Autowired
    public UserController(UserService userService) {
        this.userServicve = userService;
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/loginVerify")
    public String loginVerify(User user, Model model) {
        if (userServicve.correctInformations(user)) {
            model.addAttribute("user",user);
            model.addAttribute("users", userServicve.bringAllUsers());
        }
        return "login";
    }


    @RequestMapping("/registerVerify")
    public String registerVerify(User user) {
        if (!userServicve.usernameTaken(user)) {
            userServicve.addUser(user);
            return "success";
        }
        return "register";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

}
