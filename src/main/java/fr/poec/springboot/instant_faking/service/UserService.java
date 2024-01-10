package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.UserPostDTO;
import fr.poec.springboot.instant_faking.DTO.UserPutDTO;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;

    private CountryService countryService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User getObjectById(Long id) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundInstantFakingException("User", "id", id);
        }
        return optionalUser.get();
    }

    public User create(UserPostDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setPassword(userDTO.getPassword());

        return userRepository.saveAndFlush(user);
    }

    public User edit(Long id, UserPutDTO userPutDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) { // OBLIGATOIRE CAR ON A UN OPTIONAL
            throw new NotFoundInstantFakingException("User", "id", id);
        }
        User user = optionalUser.get();
        if (!userPutDTO.getPassword().isEmpty()) {
            user.setPassword(userPutDTO.getPassword());
        }
        user.setProfileImage(userPutDTO.getProfileImage());
        user.setNickname(userPutDTO.getNickname());
        // On s'assure avant que le countryId n'est pas null
        if (userPutDTO.getCountryId() != null) {
            user.setCountry(countryService.getObjectById(userPutDTO.getCountryId()));
        }

        // Pas besoin de save dans le cas d'un objet modifié
        // C'est-à-dire un objet qui a DEJA été persisté en BDD
        userRepository.flush();
        return user;
    }
}
