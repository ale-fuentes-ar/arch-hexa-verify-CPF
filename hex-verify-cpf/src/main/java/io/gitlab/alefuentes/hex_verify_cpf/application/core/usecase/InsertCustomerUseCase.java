package io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase;

import org.apache.kafka.common.network.Send;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.InsertCustomerInputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.FindAddressByZipCodeOutputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.InsertCustomerOutputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

}
