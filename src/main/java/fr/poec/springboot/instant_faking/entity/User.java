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
    @JsonView(JsonViews.UserShowView.class)
    private Long id;

    @JsonView(JsonViews.UserShowView.class)
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

    @JsonView(JsonViews.UserShowView.class)
    private double wallet;

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserShowView.class)
    private List<UserOwnGame> userOwnGames = new ArrayList<>();

    @ManyToOne
    @JsonView(JsonViews.UserListView.class)
    private Country country;

    @ManyToMany
    @JoinTable( // Permet de modifier la table relationnelle qui sera créée
        name = "user_wish_list", // nom de la table
        joinColumns = @JoinColumn(name = "user_id"), // renomme la colonne de l'objet courant dans la table relationnelle
        inverseJoinColumns = @JoinColumn(name = "game_id") // renomme la colonne de l'objet en relation dans la table relationnelle
    )
    @JsonView(JsonViews.UserShowView.class)
    private List<Game> wantedGames = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserShowView.class)
    private List<Review> reviews = new ArrayList<>();

    @JsonView(JsonViews.UserListView.class)
    public int getNbGames() {
        return this.userOwnGames.size();
    }

    @JsonView(JsonViews.UserShowView.class)
    public boolean isAdmin() {
        return roles.contains("[\"ROLE_ADMIN\"]");
    }

}