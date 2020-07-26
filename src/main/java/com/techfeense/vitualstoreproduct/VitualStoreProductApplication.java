package com.techfeense.vitualstoreproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class VitualStoreProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitualStoreProductApplication.class, args);
	}

}
