package com.example.kc.repository;

import com.example.kc.entity.CartItem;
import com.example.kc.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CartRepositoryTest {

    @Mock
    private CartRepository cartRepository;

    @Test
    public void addItemToCart() {

        var user = new User();

    }

    @Test
    public void findCartItemByUserId() {
        var user = new User();
        user.setId(4L);

        List<CartItem> cartItemList = cartRepository.findCartItemsByUserId(user.getId());
        assertEquals(0, cartItemList.size());
    }
}