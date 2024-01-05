package fr.poec.springboot.instant_faking.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
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

    @JsonView(JsonViews.UserListView.class)
    private String email;

    @JsonView(JsonViews.UserMinimalView.class)
    private String name;

    @JsonView(JsonViews.UserListView.class)
    private String nickname;

    private String password;

    @JsonView(JsonViews.UserMinimalView.class)
    private String profileImage;

    private String roles;

    private double wallet;

    @OneToMany(mappedBy = "user")
    private List<UserOwnGame> userOwnGames = new ArrayList<>();

    @ManyToOne
    @JsonView(JsonViews.UserListView.class)
    private Country country;

    @ManyToMany
    @JoinTable(
        name = "user_wish_list",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> wantedGames = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

}