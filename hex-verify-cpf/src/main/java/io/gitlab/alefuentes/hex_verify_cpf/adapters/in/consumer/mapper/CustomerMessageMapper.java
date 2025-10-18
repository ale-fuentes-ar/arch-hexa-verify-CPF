package io.gitlab.alefuentes.hex_verify_cpf.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.consumer.message.CustomerMessage;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
