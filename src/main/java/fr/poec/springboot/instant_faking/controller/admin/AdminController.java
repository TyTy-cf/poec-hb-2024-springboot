package fr.poec.springboot.instant_faking.controller.admin;

import fr.poec.springboot.instant_faking.mapping.UrlRoute;
import fr.poec.springboot.instant_faking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(UrlRoute.URL_ADMIN)
public class AdminController {

    private UserService userService;

    @GetMapping
    public ModelAndView admin(ModelAndView mav) {
        mav.addObject("lastUsers", userService.findTop5ByOrderByCreatedAtDesc());
        mav.setViewName("admin/admin");
        return mav;
    }

}
