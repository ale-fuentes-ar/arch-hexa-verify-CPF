package io.gitlab.alefuentes.hex_verify_cpf.application.ports.out;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
