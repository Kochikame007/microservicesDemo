package com.inventoryservice.dto;

import lombok.*;

/*
* This is the DTO class
* */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryResponse {

    private String skuCode;
    private boolean inStock;
}
