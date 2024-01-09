package fr.poec.springboot.instant_faking.DTO;

import fr.poec.springboot.instant_faking.validator.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPostDTO {

    @Email(message = "Please, give a valid email")
    // On peut réécrire les valeurs des champs de l'annotation
    @UniqueEmail(example = "TOTO, MAIS DU DTO")
    private String email;

    @NotBlank(message = "Please, give a proper name")
    private String name;

    @NotBlank(message = "Please, the password must have a value")
    private String password;

}
