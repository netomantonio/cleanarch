package com.antonio.cleanarch.config;

import com.antonio.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.antonio.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.antonio.cleanarch.dataprovider.deletecustomer.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {
    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(
                findCustomerByIdUseCase,
                deleteCustomerById
        );
    }
}
