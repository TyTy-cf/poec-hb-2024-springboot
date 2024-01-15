package fr.poec.springboot.instant_faking.service;

import fr.poec.springboot.instant_faking.DTO.UserPostDTO;
import fr.poec.springboot.instant_faking.DTO.UserPutDTO;
import fr.poec.springboot.instant_faking.entity.User;
import fr.poec.springboot.instant_faking.exception.NotFoundInstantFakingException;
import fr.poec.springboot.instant_faking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>,
                                    UserDetailsService {

    private UserRepository userRepository;

    private CountryService countryService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public User edit(Long id, UserPutDTO userPutDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) { // OBLIGATOIRE CAR ON A UN OPTIONAL
            throw new NotFoundInstantFakingException("User", "id", id);
        }
        User user = optionalUser.get();
        if (!userPutDTO.getPassword().isEmpty()) {
            user.setPassword(bCryptPasswordEncoder.encode(userPutDTO.getPassword()));
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

    // Le paramètre est un "email", c'est juste que SpringBoot appelle l'identifiant de connexion "username"
    // On doit donc définir ici, comment SpringBoot va créer un objet "UserDetails" à partir de notre objet courant, ici User
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}
