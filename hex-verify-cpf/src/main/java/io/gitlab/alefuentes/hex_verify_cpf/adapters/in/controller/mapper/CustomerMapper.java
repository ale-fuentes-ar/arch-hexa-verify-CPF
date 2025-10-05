package io.gitlab.alefuentes.hex_verify_cpf.adapters.in.controller.mapper;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.controller.request.CustomerRequest;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

}
