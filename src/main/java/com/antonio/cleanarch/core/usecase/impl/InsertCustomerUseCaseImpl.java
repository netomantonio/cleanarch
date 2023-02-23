package com.antonio.cleanarch.core.usecase.impl;

import com.antonio.cleanarch.core.dataprovider.CreateCustomer;
import com.antonio.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;

    private final CreateCustomer createCustomer;

    public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, CreateCustomer createCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.createCustomer = createCustomer;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        createCustomer.insert(customer);
    }
}
