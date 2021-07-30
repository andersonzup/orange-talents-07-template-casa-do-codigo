package br.com.zup.casadocodigo.config.validacao;

import br.com.zup.casadocodigo.cadastroestadopais.RequestEstadoDto;
import br.com.zup.casadocodigo.cadastroestadopais.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
public class ProibeEstadoDuplicadoValidator implements Validator {

    private EstadoRepository repository;
    public ProibeEstadoDuplicadoValidator(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RequestEstadoDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        RequestEstadoDto request = (RequestEstadoDto) target;

        boolean exist = repository.existsByNomeAndPais_Id(request.getNome(), request.getIdPais());

        if (exist){
            errors.rejectValue("idPais", null, "O estado "+request.getNome()+" já existe para este país");
            }
        }


}
