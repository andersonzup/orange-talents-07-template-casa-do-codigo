package br.com.zup.casadocodigo.cadastrocliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteRestController {

    ClienteRepository clienteRepository;

    @PersistenceContext
    EntityManager entityManager;

    public ClienteRestController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @Transactional
    public Cliente saveClient(@RequestBody @Valid RequestClientDto requestClientDto){
        Cliente cliente = requestClientDto.toModel(entityManager);
        return cliente;
    }
}
