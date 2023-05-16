package com.microservice.orderservice.controller;

import com.microservice.orderservice.dto.OrderRequest;
import com.microservice.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    /*@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")

     */
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        orderService.placeOrder(orderRequest);
        return "+";
        //return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        log.info("Cannot Place Order Executing Fallback logic");
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please order after some time!");
    }
}
