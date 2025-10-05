package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    private String street;
    private String city;
    private String state;

}
