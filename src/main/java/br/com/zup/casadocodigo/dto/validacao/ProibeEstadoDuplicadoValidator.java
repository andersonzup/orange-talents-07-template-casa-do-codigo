package br.com.zup.casadocodigo.dto.validacao;

import br.com.zup.casadocodigo.dto.RequestEstadoDto;
import br.com.zup.casadocodigo.entity.Estado;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Component
public class ProibeEstadoDuplicadoValidator implements Validator {
    @PersistenceContext
    EntityManager entityManager;

    EstadoRepository repository;
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
