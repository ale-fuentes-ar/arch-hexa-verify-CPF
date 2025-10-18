package io.gitlab.alefuentes.hex_verify_cpf.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {
    
    @Autowired KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
    
}
