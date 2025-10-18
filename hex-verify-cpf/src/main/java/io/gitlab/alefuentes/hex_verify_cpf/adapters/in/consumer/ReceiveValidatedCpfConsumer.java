package io.gitlab.alefuentes.hex_verify_cpf.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.consumer.mapper.CustomerMessageMapper;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.consumer.message.CustomerMessage;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.UpdateCustomerInputPort;

public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arentes")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);

        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }

}
