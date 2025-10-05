package io.gitlab.alefuentes.hex_verify_cpf.application.ports.out;

import java.util.Optional;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
