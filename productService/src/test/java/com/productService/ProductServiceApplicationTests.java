package com.productService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productService.dto.ProductRequest;
import com.productService.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//
//	/*
//	*Intializiing the mongodb container with ccontainer version
//	*/
//	@Container
//	static MongoDBContainer mdbc = new MongoDBContainer("mongo:4.4.2");
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper om;
//
//	@Autowired
//	private ProductRepository prodRepo;
//
//
//	/*
//	*setting properties to the mongodbcontainer
//	*/
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dpr){
//		dpr.add("spring.data.mongodb.url" , mdbc::getReplicaSetUrl);
//	}
//	@Test
//	void shouldCreateProduct() throws Exception {
//		ProductRequest pr = getProductRequest();
//		String stringProdReq = om.writeValueAsString(pr);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(stringProdReq))
//				.andExpect(status().isCreated());
//
//		Assertions.assertEquals(1 ,prodRepo.findAll().size()==1);
//	}
//
//	private ProductRequest getProductRequest(){
//		return ProductRequest.builder()
//				.name("iphone12")
//				.description("iphone12")
//				.price(BigDecimal.valueOf(1200))
//				.build();
//	}

}
