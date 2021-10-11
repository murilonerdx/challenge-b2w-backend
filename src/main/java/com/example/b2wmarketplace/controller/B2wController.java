package com.example.b2wmarketplace.controller;

import com.example.b2wmarketplace.exception.BadParamException;
import com.example.b2wmarketplace.model.Product;
import com.example.b2wmarketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/challenge-backend")
public class B2wController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value="/item")
    public ResponseEntity<List<Product>> getProductByDate(
            @RequestParam(value = "begindate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date beginDate,
            @RequestParam(value="finaldate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date finalDate
    ){
        try{
            List<Product> products = repository.findProductByDateBetween(
                    beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    finalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            return ResponseEntity.ok().body(products);
        }catch(RuntimeException e){
            throw new BadParamException("need begindate and finadate parameter");
        }

    }

}
