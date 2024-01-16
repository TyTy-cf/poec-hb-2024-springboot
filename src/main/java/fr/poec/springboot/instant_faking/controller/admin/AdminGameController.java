package fr.poec.springboot.instant_faking.controller.admin;

import fr.poec.springboot.instant_faking.DTO.GameDTO;
import fr.poec.springboot.instant_faking.mapping.UrlRoute;
import fr.poec.springboot.instant_faking.service.CountryService;
import fr.poec.springboot.instant_faking.service.GameService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AdminGameController {

    private GameService gameService;

    private CountryService countryService;

    @GetMapping(path = UrlRoute.URL_ADMIN_GAME_NEW, name = "new")
    public ModelAndView create(
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        mav.setViewName("admin/game/form");
        mav.addObject("gameDto", new GameDTO());
        mav.addObject("countries", countryService.findAllOrderByName());
        mav.addObject("action", httpServletRequest.getRequestURI());
        mav.addObject("isEdit", false);
        return mav;
    }

    @PostMapping(path = UrlRoute.URL_ADMIN_GAME_NEW, name = "newGameHandler")
    public ModelAndView formHandler(
            @Valid @ModelAttribute("gameDto") GameDTO gameDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        if (result.hasErrors()) {
            mav.setViewName("admin/game/form");
            return mav;
        }
        gameDTO.getCountries().forEach(country -> System.out.println(country.getName()));
        mav.setViewName("redirect:" + UrlRoute.URL_ADMIN_GAME); // FORCEMENT UN PATH (une URL de route !)
        return mav;
    }

}
