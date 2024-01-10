package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.Game;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findBySlug(String slug) {
        return gameRepository.findBySlug(slug);
    }

    public List<Game> findByCategory(String slug) {
        return gameRepository.findAllByCategoriesSlugOrderByPublishedAtDesc(slug);
    }

    public Game getObjectById(Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isEmpty()) {
            throw new NotFoundInstantFakingException("Game", "id", id);
        }
        return optionalGame.get();
    }
}
