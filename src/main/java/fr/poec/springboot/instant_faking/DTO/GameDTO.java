package fr.poec.springboot.instant_faking.DTO;

import fr.poec.springboot.instant_faking.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {

    private List<Country> countries = new ArrayList<>();

}
