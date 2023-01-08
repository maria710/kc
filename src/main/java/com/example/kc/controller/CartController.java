package com.example.kc.controller;


import com.example.kc.entity.User2;
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
        User2 user2 = new User2();
        user2.setId(1L); //TODO

        var cartItemList = cartService.cartItemListByUserId(user2.getId());
        model.addAttribute("cartItemList", cartItemList);

        return "cart";
    }

}
