package com.antonio.cleanarch.dataprovider.updatecustomer;

import com.antonio.cleanarch.core.dataprovider.UpdateCustomer;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.dataprovider.repository.CustomerRepository;
import com.antonio.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerImpl implements UpdateCustomer {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }
}
