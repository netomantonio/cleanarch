package com.antonio.cleanarch.dataprovider.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private String name;

    private String cpf;

    private AddressEntity address;

    private Boolean validCpf;

}
