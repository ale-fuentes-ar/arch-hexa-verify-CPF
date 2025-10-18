package io.gitlab.alefuentes.hex_verify_cpf.application.core.usecase;

import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.DeleteCustomerByIdInputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.in.FindCustomerByIdInputPort;
import io.gitlab.alefuentes.hex_verify_cpf.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerOutputPort.delete(id);
    }

}
