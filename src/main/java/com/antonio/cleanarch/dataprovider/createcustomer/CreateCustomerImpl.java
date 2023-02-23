package com.antonio.cleanarch.dataprovider.createcustomer;

import com.antonio.cleanarch.core.dataprovider.CreateCustomer;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.dataprovider.repository.CustomerRepository;
import com.antonio.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerImpl implements CreateCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }
}
