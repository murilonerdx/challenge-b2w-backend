package com.example.b2wmarketplace.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code;
    private LocalDateTime date;

    @ElementCollection
    private Map<String, String> dimension;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;

        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return 2042274511;
    }
}
