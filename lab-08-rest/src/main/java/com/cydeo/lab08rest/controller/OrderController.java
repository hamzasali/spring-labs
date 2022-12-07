package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO order) {
        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Order Created"
                        , orderService.create(order)
                        , HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO order) {
        orderService.update(order);
        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Order Updated successfully"
                        , HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getOrderList() {
        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Orders Retrieved Successfully"
                        , orderService.getAll()
                        , HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable String email) {
        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Order retrieved by Email"
                        , orderService.getAllByEmail(email)
                        , HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable PaymentMethod paymentMethod) {
        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Order retrieved by Payment Method"
                        , orderService.getAllByPaymentMethod(paymentMethod)
                        , HttpStatus.OK));
    }
}
