package io.gitlab.alefuentes.hex_verify_cpf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.DeleteCustomerByIdAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.DeleteCustomerByIdUseCase;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
