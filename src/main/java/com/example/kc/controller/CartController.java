package com.example.kc.controller;


import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.User2;
import com.example.kc.mapper.CartItemMapper;
import com.example.kc.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartItemMapper cartItemMapper;

    @GetMapping(value = "/cart")
    public String showCart(Model model) {

        var cartItemList = cartService.cartItems();
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("itemsCount", cartItemList.size());

        return "cart";
    }

    @GetMapping(value = "/deleteFromCart")
    public String deleteFromCart(@ModelAttribute("id") Long id) {
        cartItemMapper.toCartItemDTO(cartService.deleteCartItem(id));
        return "redirect:/cart";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/addToCart")
    public String addToCart(@ModelAttribute("id") Long productId, Model model) {

        cartItemMapper.toCartItemDTO(cartService.addToCart(productId));
        model.addAttribute("id", productId);
        return String.format("redirect:/product?id=%d", productId);
    }

}
