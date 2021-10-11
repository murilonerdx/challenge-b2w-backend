package com.example.b2wmarketplace.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorValidation {
    private String field;
    private String defaultMessage;
}