package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.repository.entitiy.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String>{

}
