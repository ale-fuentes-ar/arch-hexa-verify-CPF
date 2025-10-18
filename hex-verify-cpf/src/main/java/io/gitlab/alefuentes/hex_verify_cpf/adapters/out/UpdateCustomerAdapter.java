package io.gitlab.alefuentes.hex_verify_cpf.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.CustomerRepository;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.mapper.CustomerEntityMapper;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
        // Implementation for updating the customer in the data store
    }

}
