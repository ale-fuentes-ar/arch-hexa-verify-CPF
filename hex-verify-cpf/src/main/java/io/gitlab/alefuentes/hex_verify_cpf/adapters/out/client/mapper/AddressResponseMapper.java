package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client.mapper;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
