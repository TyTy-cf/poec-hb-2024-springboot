package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
