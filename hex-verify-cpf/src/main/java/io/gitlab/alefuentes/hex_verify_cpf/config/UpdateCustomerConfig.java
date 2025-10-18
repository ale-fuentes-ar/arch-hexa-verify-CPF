package io.gitlab.alefuentes.hex_verify_cpf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.FindAddressByZipCodeAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.UpdateCustomerAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.FindCustomerByIdUseCase;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
             FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,
                findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
