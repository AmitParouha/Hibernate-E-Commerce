package com.spring.jpa;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class HibernateECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateECommerceApplication.class, args);
	}

}
