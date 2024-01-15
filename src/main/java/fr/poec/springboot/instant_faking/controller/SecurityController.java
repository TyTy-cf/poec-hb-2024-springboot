package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.DTO.UserPostDTO;
import fr.poec.springboot.instant_faking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class SecurityController {

    private UserService userService;

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mav) {
        mav.setViewName("security/register");
        mav.addObject("userForm", new UserPostDTO());
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userForm") UserPostDTO userForm, BindingResult bindingResult, ModelAndView mav) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("security/register");
            return mav;
        }
        userService.create(userForm);
        mav.setViewName("redirect:/login");
        return mav;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView mav, String error) {
        if (error != null) {
            mav.addObject("error", "Your username and password is invalid.");
        }
        mav.setViewName("security/login");
        return mav;
    }

}
