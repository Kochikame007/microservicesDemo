package com.orderservice.service;

import com.orderservice.dto.InventoryResponse;
import com.orderservice.dto.OrderLineItemsDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.model.Order;
import com.orderservice.model.OrderLineItem;
import com.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepo;
    private final WebClient webClient;

    public void placeOrder(OrderRequest or) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> loli = or.getOrderLineItemsDtoList().stream().map(this::mapToOrderLineItem).toList();
        order.setOrderLineItemList(loli);


//        call inventory controller to check if the item is available
        List<String> skuCode = order.getOrderLineItemList().stream().map(item -> item.getSkuCode()).toList();
        InventoryResponse[] result = webClient.get()
                .uri("http://localhost:8082/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCode).build())
                .retrieve().bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductInStock = Arrays.stream(result).allMatch(InventoryResponse::isInStock);

        if (allProductInStock) {
            orderRepo.save(order);

        } else {
            throw new IllegalArgumentException("Product not availble");
        }


    }

    public OrderLineItem mapToOrderLineItem(OrderLineItemsDto olid) {
        OrderLineItem oli = new OrderLineItem();
        oli.setQuantity(olid.getQuantity());
        oli.setPrice(olid.getPrice());
        oli.setSkuCode(olid.getSkuCode());

        return oli;

    }
}
