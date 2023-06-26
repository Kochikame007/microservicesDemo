package com.inventoryservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryResponse {

    private String skuCode;
    private boolean inStock;
}
