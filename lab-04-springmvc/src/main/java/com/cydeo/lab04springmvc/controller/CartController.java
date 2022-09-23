package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Cart;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

    @RequestMapping("/cart-list")
    public String cartList(Model model) {

        model.addAttribute("cartList", CartServiceImpl.CART_LIST);
        model.addAttribute("cart", new Cart());
        return "cart/cart-list";
    }

    @RequestMapping("/cart-list/{cartId}")
    public String cartDet(@PathVariable UUID cartId, Model model) {

        model.addAttribute("cartItem", CartServiceImpl.CART_LIST);

        return "cart/cart-detail";
    }

}
