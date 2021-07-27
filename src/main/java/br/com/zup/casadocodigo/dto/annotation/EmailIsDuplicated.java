package br.com.zup.casadocodigo.dto.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;


@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = EmailDuplicatadeValidator.class)
public @interface EmailIsDuplicated {
    String message() default "Esse email já está cadastrado, não é possivel realizar esta operação";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String value() default "";
}
