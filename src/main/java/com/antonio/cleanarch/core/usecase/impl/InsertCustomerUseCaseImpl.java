package com.antonio.cleanarch.core.usecase.impl;

import com.antonio.cleanarch.core.dataprovider.CreateCustomer;
import com.antonio.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.antonio.cleanarch.core.dataprovider.SendCpfForValidation;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;

    private final CreateCustomer createCustomer;

    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            CreateCustomer createCustomer,
            SendCpfForValidation sendCpfForValidation) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.createCustomer = createCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        createCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
    }
}
