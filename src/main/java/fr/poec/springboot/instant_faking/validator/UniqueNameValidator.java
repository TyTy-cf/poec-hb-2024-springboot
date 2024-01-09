package fr.poec.springboot.instant_faking.validator;

import fr.poec.springboot.instant_faking.repository.CountryRepository;
import fr.poec.springboot.instant_faking.validator.annotation.UniqueName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private CountryRepository countryRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        // Must get something from the annotation...
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return countryRepository.findByNameOrCodeOrSlugOrNationality(s, s, s, s).isEmpty();
    }

}
