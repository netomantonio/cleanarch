package com.antonio.cleanarch.config;

import com.antonio.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.antonio.cleanarch.dataprovider.createcustomer.CreateCustomerImpl;
import com.antonio.cleanarch.dataprovider.findaddress.impl.FindAddressByZipCodeImpl;
import com.antonio.cleanarch.dataprovider.sendCpfValidation.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            CreateCustomerImpl createCustomer,
            SendCpfForValidationImpl sendCpfForValidation
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, createCustomer, sendCpfForValidation);
    }
}
