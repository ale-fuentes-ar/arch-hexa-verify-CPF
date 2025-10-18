package io.gitlab.alefuentes.hex_verify_cpf.application.ports.out;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);

}
