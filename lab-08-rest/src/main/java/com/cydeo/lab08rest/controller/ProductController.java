package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Product created",
                productService.create(product),
                HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO product) {

        return ResponseEntity.ok(new ResponseWrapper(
                "Product updated",
                productService.update(product),
                HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getProductList() {
        return ResponseEntity.ok(new ResponseWrapper(
                "Products Retrieved",
                productService.getAll(),
                HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList() {
        return ResponseEntity.ok(new ResponseWrapper(
                "Top 3 Products",
                productService.getTop3All(),
                HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Product by name",
                productService.getByName(name),
                HttpStatus.OK));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Product List by Category",
                productService.getAllByCategory(id),
                HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Product List by Price",
                productService.countByPrice(price),
                HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable BigDecimal price, @PathVariable Integer quantity) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Product List by Price and Quantity",
                productService.getAllByPriceAndQuantity(price, quantity),
                HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> retrieveProductByCategoryAndPrice(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new ResponseWrapper(
                "Products are successfully retrieved",
                productService.retrieveProductByCategoryAndPrice(productRequest.getCategoryList(), productRequest.getPrice()),
                HttpStatus.OK));
    }
}
