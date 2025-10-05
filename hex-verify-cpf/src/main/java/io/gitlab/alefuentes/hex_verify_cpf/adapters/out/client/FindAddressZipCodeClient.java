package io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import io.gitlab.alefuentes.hex_verify_cpf.adapters.out.client.response.AddressResponse;

@FeignClient(
    name = "FindAddressZipCodeClient",
    url = "${arantes.client.address.url}"
)
public interface FindAddressZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);

}
