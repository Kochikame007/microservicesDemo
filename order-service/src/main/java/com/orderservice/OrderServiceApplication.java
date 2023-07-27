package com.orderservice;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

//	@Bean
//	public ConsumerFactory<String, Object> consumerFactory() {
//		return new DefaultKafkaConsumerFactory<>(consumerConfigs(),  new StringDeserializer(),
//				new JsonDeserializer<>(Object.class,false));
//	}

}
