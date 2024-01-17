package fr.poec.springboot.instant_faking.controller.app;

import fr.poec.springboot.instant_faking.DTO.UserPutDTO;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.mapping.UrlRoute;
import fr.poec.springboot.instant_faking.service.CountryService;
import fr.poec.springboot.instant_faking.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private CountryService countryService;

    @GetMapping(UrlRoute.URL_USER + "/{name}")
    public ModelAndView profile(
        ModelAndView mav,
        @PathVariable String name,
        HttpServletRequest request
    ) {
        User user = userService.findByName(name);
        return getViewProfileByUser(mav, request, user);
    }

    @PostMapping(UrlRoute.URL_USER + "/{name}")
    public ModelAndView profile(
            ModelAndView mav,
            @PathVariable String name,
            HttpServletRequest request,
            @ModelAttribute("userPutDto") UserPutDTO userPutDTO
    ) {
        User user = userService.edit(name, userPutDTO);
        return getViewProfileByUser(mav, request, user);
    }

    private ModelAndView getViewProfileByUser(
            ModelAndView mav,
            HttpServletRequest request,
            User user
    ) {
        mav.setViewName("user/profile");
        mav.addObject("userPutDto", userService.getUserPutDTOByUser(user));
        mav.addObject("user", user);
        mav.addObject("countries", countryService.findAllOrderByName());
        mav.addObject("uri", request.getRequestURI());
        return mav;
    }

}
