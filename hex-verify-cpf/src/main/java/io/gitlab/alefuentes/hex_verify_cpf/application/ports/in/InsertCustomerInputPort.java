package io.gitlab.alefuentes.hex_verify_cpf.application.ports.in;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
