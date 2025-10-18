package io.gitlab.alefuentes.hex_verify_cpf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.FindCustomerByIdAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
