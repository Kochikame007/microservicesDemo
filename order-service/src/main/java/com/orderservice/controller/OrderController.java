package com.orderservice.controller;

import com.orderservice.dto.OrderRequest;
import com.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import org.apache.hc.core5.concurrent.CompletedFuture;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final Tracer tracer;

    private final ObservationRegistry registry;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest or) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(or));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderReq, RuntimeException runTimeException) {
        return CompletableFuture.supplyAsync(() -> "Service seema to be down, Please try again!");
    }
}
