package com.antonio.cleanarch.core.usecase;

import com.antonio.cleanarch.core.domain.Customer;
import org.springframework.stereotype.Component;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
