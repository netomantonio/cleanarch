package com.antonio.cleanarch.dataprovider.findaddress.client;

import com.antonio.cleanarch.dataprovider.findaddress.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressZipCodeClient",
        url = "${antonio.client.address.url}"
)
public interface FindAddressZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);
}
