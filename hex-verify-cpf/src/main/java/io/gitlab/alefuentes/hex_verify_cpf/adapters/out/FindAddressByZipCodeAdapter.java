package io.gitlab.alefuentes.hex_verify_cpf.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client.mapper.AddressResponseMapper;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Address;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeOutputPort findAddressByZipCodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
