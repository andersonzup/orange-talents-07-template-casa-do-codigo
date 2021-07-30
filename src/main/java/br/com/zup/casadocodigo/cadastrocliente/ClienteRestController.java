package br.com.zup.casadocodigo.cadastrocliente;

import br.com.zup.casadocodigo.config.validacao.EstadoCadastradoValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteRestController {

    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private EstadoCadastradoValidator estadoCadastradoValidator;

    public ClienteRestController(ClienteRepository clienteRepository, EstadoCadastradoValidator estadoCadastradoValidator) {
        this.clienteRepository = clienteRepository;
        this.estadoCadastradoValidator = estadoCadastradoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoCadastradoValidator);
    }

    @PostMapping
    @Transactional
    public String saveClient(@RequestBody @Valid RequestClientDto requestClientDto){
        Cliente cliente = requestClientDto.toModel(entityManager);
        clienteRepository.save(cliente);
        return "Cliente salvo com id: " + cliente.getId();
    }


}
