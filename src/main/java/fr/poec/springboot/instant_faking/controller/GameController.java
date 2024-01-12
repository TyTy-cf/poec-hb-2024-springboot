package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.DTO.ReviewDTO;
import fr.poec.springboot.instant_faking.entity.Game;
import fr.poec.springboot.instant_faking.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/game", name = "AppGame")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Game game = gameService.findBySlug(slug);
        // Initialisation du ReviewDTO
        ReviewDTO dto = new ReviewDTO();
        dto.setGameId(game.getId());
        dto.setUserId(1L);
        mav.setViewName("game/show");
        mav.addObject("game", game);
        return mav;
    }

    @GetMapping(path = "/search/{searched}", name = "search")
    public ModelAndView search(@PathVariable String searched, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("gamesReleased", gameService.findAllBySearchedValue(searched));
        return mav;
    }

}
