package com.antonio.cleanarch.config;

import com.antonio.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.antonio.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.antonio.cleanarch.dataprovider.findaddress.impl.FindAddressByZipCodeImpl;
import com.antonio.cleanarch.dataprovider.updatecustomer.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipCodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer
    ) {
        return new UpdateCustomerUseCaseImpl(
                findCustomerByIdUseCase,
                findAddressByZipCode,
                updateCustomer
        );
    }

}
