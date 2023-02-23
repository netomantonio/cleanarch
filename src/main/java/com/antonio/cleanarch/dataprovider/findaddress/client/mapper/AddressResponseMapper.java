package com.antonio.cleanarch.dataprovider.findaddress.client.mapper;

import com.antonio.cleanarch.core.domain.Address;
import com.antonio.cleanarch.dataprovider.findaddress.client.response.AddressResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
