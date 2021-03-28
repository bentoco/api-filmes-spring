package br.com.bei.moviesapi.config.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = MustBeUniqueValidator.class)
public @interface MustBeUnique {
    String message() default "o valor deve ser unico";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> target();

    String column();

}
