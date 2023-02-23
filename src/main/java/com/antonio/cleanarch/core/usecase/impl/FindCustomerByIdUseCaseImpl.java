package com.antonio.cleanarch.core.usecase.impl;

import com.antonio.cleanarch.core.dataprovider.FindCustomerById;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.core.usecase.FindCustomerByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        return findCustomerById.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
