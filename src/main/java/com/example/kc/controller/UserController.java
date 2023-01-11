package com.example.kc.controller;

import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import com.example.kc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String registerUser(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bindingResult, Model model) {

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

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//        User2 user = userService.findByUsernameAndPassword(username, password);
//        if (user != null) {
//            return "redirect:/";
//        } else {
//            // login failed, display error message
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
        return "login";
    }
}
