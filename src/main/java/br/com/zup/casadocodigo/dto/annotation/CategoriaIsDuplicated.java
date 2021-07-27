package br.com.zup.casadocodigo.dto.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = CategorialDuplicatadeValidator.class)
public @interface CategoriaIsDuplicated {
    String message() default "Categoria já está cadastrado, não é possivel realizar esta operação";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String value() default "";
}
