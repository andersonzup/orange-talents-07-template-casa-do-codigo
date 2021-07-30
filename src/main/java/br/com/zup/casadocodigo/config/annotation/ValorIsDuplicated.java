package br.com.zup.casadocodigo.config.annotation;

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
    String message() default "{Duplicidade no sistema}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String value() default "";
    String fieldName();
    Class<?> domainClass();

}
