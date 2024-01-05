package fr.poec.springboot.instant_faking.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import fr.poec.springboot.instant_faking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;

    @GetMapping
    @JsonView(JsonViews.UserListView.class)
    List<User> list() {
        return userService.findAll();
    }

}