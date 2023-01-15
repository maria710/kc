package com.example.kc.mapper;

import com.example.kc.dto.CartItemDTO;
import com.example.kc.entity.CartItem;

public class CartItemMapper {
    public CartItem toCartItem(CartItemDTO cartItemDTO) {
        var cartItem = new CartItem();
        cartItem.setId(cartItemDTO.getId());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setProduct(cartItemDTO.getProduct());

        return cartItem;
    }

    public CartItemDTO toCartItemDTO(CartItem cartItem) {
        var cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(cartItem.getId());
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setProduct(cartItem.getProduct());

        return cartItemDTO;
    }
}
