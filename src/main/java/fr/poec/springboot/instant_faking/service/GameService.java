package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.Game;
import fr.poec.springboot.instant_faking.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

}
