package com.example.kc.repository;

import com.example.kc.entity.CartItem;
import com.example.kc.entity.User2;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CartRepositoryTest {

    @Mock
    private CartRepository cartRepository;

    @Test
    public void addItemToCart() {

        var user = new User2();

    }

    @Test
    public void findCartItemByUserId() {
        var user = new User2();
        user.setId(4L);

        List<CartItem> cartItemList = cartRepository.findCartItemsByUser2Id(user.getId());
        assertEquals(0, cartItemList.size());
    }
}