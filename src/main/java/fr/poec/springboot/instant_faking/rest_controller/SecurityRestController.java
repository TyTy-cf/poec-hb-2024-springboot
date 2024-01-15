package fr.poec.springboot.instant_faking.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.DTO.UserLoginDTO;
import fr.poec.springboot.instant_faking.DTO.UserPostDTO;
import fr.poec.springboot.instant_faking.custom_response.JwtTokenResponse;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import fr.poec.springboot.instant_faking.service.UserService;
import fr.poec.springboot.instant_faking.service.security.JwtAuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SecurityRestController {

    private UserService userService;

    private JwtAuthenticationService jwtAuthenticationService;

    @PostMapping("/register")
    @JsonView(JsonViews.UserShowView.class)
    User create(@Valid @RequestBody UserPostDTO userDTO) {
        return userService.create(userDTO);
    }

    @PostMapping("/login")
    ResponseEntity<JwtTokenResponse> create(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return jwtAuthenticationService.authenticate(userLoginDTO);
    }

}
