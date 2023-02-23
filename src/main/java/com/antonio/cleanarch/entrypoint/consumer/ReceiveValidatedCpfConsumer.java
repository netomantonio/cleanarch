package com.antonio.cleanarch.entrypoint.consumer;

import com.antonio.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.antonio.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.antonio.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "antonio")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toDomain(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }
}
