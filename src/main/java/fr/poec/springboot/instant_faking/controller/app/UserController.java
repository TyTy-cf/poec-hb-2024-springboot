package fr.poec.springboot.instant_faking.controller.app;

import fr.poec.springboot.instant_faking.mapping.UrlRoute;
import fr.poec.springboot.instant_faking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping(UrlRoute.URL_USER + "/{name}")
    public ModelAndView profile(
        ModelAndView mav,
        @PathVariable String name
    ) {
        mav.setViewName("user/profile");
        mav.addObject("user", userService.findByName(name));
        return mav;
    }

}
