package com.example.kc.controller;

import com.example.kc.dto.UserDTO;
import com.example.kc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping(value = "/registerUser")
    public String registerUser(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bindingResult,  Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "redirect:/register?fail";
        }

        if (userService.userExists(userDTO)) {
            bindingResult.rejectValue("email", "Account with this email is already registered!");
        }
        var user2 = userService.addUser(userDTO);
        if (user2 != null) {
            return "completedRegistration";
        }
        return "redirect:/register?fail";
    }

    @GetMapping(value = "/listAllUsers")
    public String getListOfAllUsers() {
        return "users";
    }

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }
}
