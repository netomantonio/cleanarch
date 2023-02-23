package com.antonio.cleanarch.config;

import com.antonio.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.antonio.cleanarch.dataprovider.findcustomer.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerByIdImpl findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }
}
