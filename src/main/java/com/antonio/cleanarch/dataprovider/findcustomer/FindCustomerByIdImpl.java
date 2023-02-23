package com.antonio.cleanarch.dataprovider.findcustomer;

import com.antonio.cleanarch.core.dataprovider.FindCustomerById;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.dataprovider.repository.CustomerRepository;
import com.antonio.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerEntityMapper.toDomain(entity));
    }
}
