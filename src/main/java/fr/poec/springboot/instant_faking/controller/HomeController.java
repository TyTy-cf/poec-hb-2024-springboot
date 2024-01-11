package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private GameService gameService;

    @GetMapping
    public ModelAndView home(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("gamesReleased", gameService.findTop9ByOrderByPublishedAtDesc());
        return mav;
    }

}
