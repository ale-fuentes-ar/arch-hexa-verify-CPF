package io.gitlab.alefuentes.hex_verify_cpf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.FindAddressByZipCodeAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.InsertCustomerAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.SendCpfForValidationAdapter;
import io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter,
                sendCpfForValidationAdapter);
    }

}
