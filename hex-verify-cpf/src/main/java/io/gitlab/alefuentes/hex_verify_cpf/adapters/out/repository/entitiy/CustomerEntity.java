package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.entitiy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isvalidCpf;

}
