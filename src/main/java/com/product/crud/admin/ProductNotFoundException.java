package com.product.crud.admin;

public class ProductNotFoundException extends Throwable {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
