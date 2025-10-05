package io.gitlab.alefuentes.hex_verify_cpf.application.ports.out;

import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
