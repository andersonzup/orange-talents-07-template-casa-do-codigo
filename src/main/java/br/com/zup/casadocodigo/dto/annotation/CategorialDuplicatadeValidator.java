package br.com.zup.casadocodigo.dto.annotation;

import br.com.zup.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategorialDuplicatadeValidator implements ConstraintValidator<CategoriaIsDuplicated, String> {

    CategoriaRepository categoriaRepository;

    public CategorialDuplicatadeValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext){
        if (categoriaRepository.existsByName(value))
            return false;
     return true;

    }
}
