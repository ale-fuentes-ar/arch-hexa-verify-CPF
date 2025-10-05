package io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Address;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.InsertCustomerInputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.FindAddressByZipCodeOutputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.InserCustomerOutputPort;

public class InsertCustomUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InserCustomerOutputPort inserCustomerOutputPort;

    public InsertCustomUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InserCustomerOutputPort inserCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.inserCustomerOutputPort = inserCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        inserCustomerOutputPort.insert(customer);
    }

}
