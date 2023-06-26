package com.orderservice.service;

import com.orderservice.dto.OrderLineItemsDto;
import com.orderservice.dto.OrderRequest;
import com.orderservice.model.Order;
import com.orderservice.model.OrderLineItem;
import com.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepo;
    public void placeOrder(OrderRequest or) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> loli = or.getOrderLineItemsDtoList().stream().map(this::mapToOrderLineItem).toList();
        order.setOrderLineItemList(loli);
        orderRepo.save(order);

    }

    public OrderLineItem mapToOrderLineItem(OrderLineItemsDto olid) {
        OrderLineItem oli = new OrderLineItem();
        oli.setQuantity(olid.getQuantity());
        oli.setPrice(olid.getPrice());
        oli.setSkuCode(olid.getSkuCode());

        return oli;

    }
}
