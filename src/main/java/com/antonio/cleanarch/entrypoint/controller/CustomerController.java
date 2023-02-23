package com.antonio.cleanarch.entrypoint.controller;

import com.antonio.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.antonio.cleanarch.core.usecase.InsertCustomerUseCase;
import com.antonio.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.antonio.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.antonio.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.antonio.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CustomerRequest customerRequest) {

        var customer = customerMapper.toDomain(customerRequest);

        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {

        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toResponse(customer);

        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toDomain(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
