package com.example.kc.service;

import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.CartItem;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.repository.CartRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductMapper productMapper;
    private final ProductService productService;

    public List<CartItem> cartItems() {
        return cartRepository.findCartItemsByActiveTrue();
    }

    public CartItem addToCart(Long productId) {
        var cartItem = new CartItem();
        var product = productService.getProduct(productId);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setActive(true);
        cartRepository.save(cartItem);
        return cartItem;
    }

    public CartItem deleteCartItem(Long id) {
        var cartItem = cartRepository.findById(id);
        cartItem.ifPresent(c -> c.setActive(false));
        cartItem.ifPresent(cartRepository::save);
        return cartItem.orElse(null);
    }

}
