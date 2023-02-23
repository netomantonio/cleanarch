package com.antonio.cleanarch.entrypoint.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String id;

    private String name;

    private String cpf;

    private AddressResponse address;

    private Boolean validCpf;
}
