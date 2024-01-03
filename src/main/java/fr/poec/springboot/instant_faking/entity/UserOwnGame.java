package fr.poec.springboot.instant_faking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UserOwnGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    private int gameTime;

    private Date lastUsedAt;

    private boolean isInstalled;

    @ManyToOne
    private User user;

    @ManyToOne
    private Game game;

}