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
    public String registerUser(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult,  Model model) {

        if (bindingResult.hasFieldErrors()) {
            return "register";
        }

        model.addAttribute("firstName", userDTO.getFirstName());
        model.addAttribute("lastName", userDTO.getLastName());
        model.addAttribute("password", userDTO.getPassword());
        model.addAttribute("email", userDTO.getEmail());

        userService.addUser(userDTO);
        return "completedRegistration";
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
