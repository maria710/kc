package com.example.kc.service;

import com.example.kc.entity.CartItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Test
    public void getCartItemListByUserIdTest() {
        List<CartItem> list = cartService.cartItems();

        assertThat(list).isNotNull();
        assertThat(list).isEmpty();
    }
}