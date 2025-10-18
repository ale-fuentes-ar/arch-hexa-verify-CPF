package io.gitlab.alefuentes.hex_verify_cpf.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.CustomerRepository;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.DeleteCustomerOutputPort;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id); // Implementation for deleting a customer by ID
    }

}
