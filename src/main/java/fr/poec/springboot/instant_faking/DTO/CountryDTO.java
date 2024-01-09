package fr.poec.springboot.instant_faking.DTO;

import fr.poec.springboot.instant_faking.validator.annotation.UniqueName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@UniqueName
public class CountryDTO {

    @NotBlank(message = "The name must have a value")
    private String name;

    @NotBlank(message = "The nationality must have a value")
    private String nationality;

    @Pattern(
        regexp = "[a-zA-Z]{2}",
        message = "The code must be on 2 characters only"
    )
    @NotBlank(message = "The code must have a value")
    private String code;

}
