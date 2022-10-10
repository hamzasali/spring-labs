package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        Product product = productService.findProductById(productId);
        CartItem cartItem = new CartItem();

        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        if (CART.getCartItemList().stream().noneMatch(item -> item.getProduct().getId().toString().equals(cartItem.getProduct().getId().toString()))){
            CART.getCartItemList().add(cartItem);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        }

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){

        CartItem deleteItem = CART.getCartItemList().stream()
                .filter(p -> p.getProduct().getId().toString().equals(productId.toString()))
                .findFirst().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(deleteItem.getTotalAmount()));

        return CART.getCartItemList().remove(deleteItem);
    }
}
