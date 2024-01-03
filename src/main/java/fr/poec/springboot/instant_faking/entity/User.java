package fr.poec.springboot.instant_faking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private String email;

    private String name;

    private String nickname;

    private String password;

    private String profileImage;

    private String roles;

    private double wallet;

    @OneToMany(mappedBy = "user")
    private List<UserOwnGame> userOwnGames = new ArrayList<>();

    @ManyToOne
    private Country country;

    @ManyToMany
    @JoinTable(
        name = "user_wish_list",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> wantedGames = new ArrayList<>();

}