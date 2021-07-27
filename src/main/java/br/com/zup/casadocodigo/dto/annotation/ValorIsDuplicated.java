package br.com.zup.casadocodigo.dto.annotation;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ValorDuplicatadeValidator.class)
public @interface ValorIsDuplicated {
    String message() default "{br.com.zup.casadocodigo.beanvalidation.valorisduplicated}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String value() default "";
    String nomeCampo();
    Class<?> classeDeDominio();

}
