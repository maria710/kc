package com.example.kc.controller;


import com.example.kc.entity.User;
import com.example.kc.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {


    private final CartService cartService;

    @GetMapping(value = "/")
    public String showCart(Model model) {
        User user = new User();
        user.setId(1L); //TODO

        var cartItemList = cartService.cartItemListByUserId(user.getId());
        model.addAttribute("cartItemList", cartItemList);

        return "cart";
    }

}
