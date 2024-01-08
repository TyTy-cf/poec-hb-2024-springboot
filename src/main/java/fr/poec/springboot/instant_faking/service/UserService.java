package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.UserDTO;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User create(UserDTO userDTO) {
        return new User();
    }
}
