package com.antonio.cleanarch.entrypoint.controller.request;


import lombok.Data;

@Data
public class CustomerRequest {

    private String name;

    private String cpf;

    private String zipCode;

    public String getZipCode() {
        return zipCode;
    }
}
