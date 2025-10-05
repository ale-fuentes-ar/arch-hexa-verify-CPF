package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.mapper;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.entitiy.CustomerEntity;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.domain.Customer;
import org.mastruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
