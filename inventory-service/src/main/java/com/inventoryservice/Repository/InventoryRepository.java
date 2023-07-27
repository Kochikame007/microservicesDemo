package com.inventoryservice.Repository;

import com.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * This is the repository class the accessa and manages data for the inventory
 * */
@Repository

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Optional<Inventory> findBySkuCode(String skuCode);

    /*
     * Method to retrieve list of inventory from within the passed Skucode
     * @param A list of {@link skuCode} to search for
     * @return list of inventory
     * */
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
