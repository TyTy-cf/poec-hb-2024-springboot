package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.UserPostDTO;
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

    public User create(UserPostDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return userRepository.saveAndFlush(user);
    }
}
