package fr.poec.springboot.instant_faking.validator.annotation;

import fr.poec.springboot.instant_faking.validator.UniqueEmailValidator;
import fr.poec.springboot.instant_faking.validator.UniqueNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UniqueName {

    // MAYBE, JUST MAYBE : THERE SOMETHING TO ADD THERE

    String message() default "This name already exists !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
