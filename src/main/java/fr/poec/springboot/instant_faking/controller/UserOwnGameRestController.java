package fr.poec.springboot.instant_faking.controller;

import fr.poec.springboot.instant_faking.entity.UserOwnGame;
import fr.poec.springboot.instant_faking.repository.UserOwnGameRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user_own_game")
public class UserOwnGameRestController {

    private UserOwnGameRepository userOwnGameRepository;

    @GetMapping
    public List<UserOwnGame> list() {
        return this.userOwnGameRepository.findAll();
    }

}