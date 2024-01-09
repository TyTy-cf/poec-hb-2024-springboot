package fr.poec.springboot.instant_faking.validator.annotation;

import fr.poec.springboot.instant_faking.validator.PastDateValidator;
import fr.poec.springboot.instant_faking.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PastDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PastDate {

}
