package com.example.b2wmarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class B2wMarketplaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(B2wMarketplaceApplication.class, args);
    }
}
