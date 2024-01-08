package fr.poec.springboot.instant_faking.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.DTO.UserDTO;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import fr.poec.springboot.instant_faking.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.UserShowView.class)
    Optional<User> show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.UserShowView.class)
    User create(@Valid @RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

}