package com.inventoryservice.Service;

import com.inventoryservice.Repository.InventoryRepository;
import com.inventoryservice.dto.InventoryResponse;
import com.inventoryservice.model.Inventory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository invRepo;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> inStock(List<String> skuCode) {
        log.info("Inventory wait started");
        Thread.sleep(10000);
        log.info("Inventory wait ended");
        return invRepo.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .inStock(inventory.getQuantity() > 0)
                        .build()).toList();
    }
}
