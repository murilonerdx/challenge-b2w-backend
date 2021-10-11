package com.example.b2wmarketplace.config;

import com.example.b2wmarketplace.model.Product;
import com.example.b2wmarketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Profile("test")
@Configuration
@RequiredArgsConstructor
public class DbInitializer {

    final String URL_MOCK_PRODUCT = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    @Autowired
    private ProductRepository repository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public boolean instantiateDatabase(){
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<Product>> response = restTemplate.exchange(
                URL_MOCK_PRODUCT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        List<Product> productMock = response.getBody();


        if (productMock != null && !productMock.isEmpty()) repository.saveAll(productMock);
        return true;
    }


}
