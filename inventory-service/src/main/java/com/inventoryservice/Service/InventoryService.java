package com.inventoryservice.Service;

import com.inventoryservice.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository invRepo;

    @Transactional(readOnly = true)
    public boolean inStock(String skuCode){
        return invRepo.findBySkuCode(skuCode).isPresent();
    }
}
