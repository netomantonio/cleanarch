package com.antonio.cleanarch.dataprovider.findaddress.impl;

import com.antonio.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.antonio.cleanarch.core.domain.Address;
import com.antonio.cleanarch.dataprovider.findaddress.client.FindAddressZipCodeClient;
import com.antonio.cleanarch.dataprovider.findaddress.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressZipCodeClient findAddressZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {

        var addressResponse = findAddressZipCodeClient.find(zipCode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
