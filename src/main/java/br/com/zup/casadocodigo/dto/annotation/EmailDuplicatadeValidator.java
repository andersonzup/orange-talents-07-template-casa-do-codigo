package br.com.zup.casadocodigo.dto.annotation;

import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailDuplicatadeValidator implements ConstraintValidator<EmailIsDuplicated, String> {

    AutorRepository autorRepository;

    public EmailDuplicatadeValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext){
        if (autorRepository.existsByEmail(value))
            return false;
     return true;

    }
}
