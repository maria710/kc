package com.example.kc.service;

import com.example.kc.entity.CartItem;
import com.example.kc.repository.CartRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<CartItem> cartItemListByUserId(Long id) {
        return cartRepository.findCartItemsByUser2Id(id);
    }

}
