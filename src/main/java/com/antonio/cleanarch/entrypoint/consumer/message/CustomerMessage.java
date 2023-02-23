package com.antonio.cleanarch.entrypoint.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMessage {
    private String id;
    private String name;
    private String zepCode;
    private String cpf;
    private Boolean validCpf;
}
