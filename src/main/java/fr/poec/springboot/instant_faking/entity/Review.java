package fr.poec.springboot.instant_faking.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ReviewListView.class)
    private Long id;

    @JsonView(JsonViews.ReviewListView.class)
    private String content;

    @JsonView(JsonViews.ReviewListView.class)
    private Date createdAt;

    @JsonView(JsonViews.ReviewListView.class)
    private int downVote;

    @JsonView(JsonViews.ReviewListView.class)
    private int upVote;

    @JsonView(JsonViews.ReviewListView.class)
    private double rating;

    @JsonView(JsonViews.ReviewListView.class)
    private String title;

    @ManyToOne
    @JsonView(JsonViews.ReviewListView.class)
    private User user;

    @ManyToOne
    @JsonView(JsonViews.ReviewListView.class)
    private Game game;

}