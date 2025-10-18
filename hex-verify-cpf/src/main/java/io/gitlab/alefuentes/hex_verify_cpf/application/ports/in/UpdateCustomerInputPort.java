package io.gitlab.alefuentes.hex_verify_cpf.application.ports.in;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
