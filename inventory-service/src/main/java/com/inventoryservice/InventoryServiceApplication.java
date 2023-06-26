package com.inventoryservice;

import com.inventoryservice.Repository.InventoryRepository;
import com.inventoryservice.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository invRepo){
		return args ->{
			Inventory i = new Inventory();
			i.setQuantity(160);
			i.setSkuCode("black");

			Inventory i2 = new Inventory();
			i.setQuantity(160);
			i.setSkuCode("red");

			invRepo.save(i);
			invRepo.save(i2);
		};
	}

}
