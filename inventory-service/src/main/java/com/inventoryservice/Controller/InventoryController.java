package com.inventoryservice.Controller;

import com.inventoryservice.Service.InventoryService;
import com.inventoryservice.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Rest class responsible for handling http request requests
 * provides endpoints for retrieving inventory details
 * */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService invService;


    /*
     * Handles http Get method to retrieve inventory details
     * @param {@link skuCode} A list of sku codes for which the inventory information is requested
     * @return A list of {@link InventoryResponse} containing inventory information
     * */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> inStock(@RequestParam List<String> skuCode) {
        return invService.inStock(skuCode);
    }
}
