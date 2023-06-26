package com.inventoryservice.Service;

import com.inventoryservice.Repository.InventoryRepository;
import com.inventoryservice.dto.InventoryResponse;
import com.inventoryservice.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository invRepo;

    @Transactional(readOnly = true)
    public List<InventoryResponse> inStock(List<String> skuCode) {
        return invRepo.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .inStock(inventory.getQuantity() > 0)
                        .build()).toList();
    }
}
