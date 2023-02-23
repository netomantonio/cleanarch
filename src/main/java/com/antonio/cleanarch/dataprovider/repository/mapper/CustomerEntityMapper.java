package com.antonio.cleanarch.dataprovider.repository.mapper;

import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);

    Customer toDomain(CustomerEntity customerEntity);

}
