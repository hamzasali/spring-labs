package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Cart;
import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/search-product/{name}")
    public String productSearch(Model model, @PathVariable String name) {

        model.addAttribute("productList", productService.searchProduct(name));

        return "product/product-list";
    }
}
