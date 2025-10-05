package io.gitlab.alefuentes.hex_verify_cpf.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.controller.mapper.CustomerMapper;
import io.gitlab.alefuentes.hex_verify_cpf.adapters.in.controller.request.CustomerRequest;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

}
