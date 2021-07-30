package br.com.zup.casadocodigo.cadastroestadopais;

import br.com.zup.casadocodigo.config.validacao.ProibeEstadoDuplicadoValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoRestController {

    private EstadoRepository estadoRepository;

    private ProibeEstadoDuplicadoValidator proibeEstadoDuplicadoValidator;

    @PersistenceContext
    EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEstadoDuplicadoValidator);
    }

    public EstadoRestController(EstadoRepository estadoRepository, ProibeEstadoDuplicadoValidator proibeEstadoDuplicadoValidator) {
        this.estadoRepository = estadoRepository;
        this.proibeEstadoDuplicadoValidator = proibeEstadoDuplicadoValidator;
    }

    @PostMapping
    @Transactional
    public String saveEstado(@RequestBody @Valid RequestEstadoDto estadoDto){
        Estado estado = estadoDto.toModel(entityManager);
         estadoRepository.save(estado);
        return estado.getNome() + " cadastrado com sucesso";
    }




}
