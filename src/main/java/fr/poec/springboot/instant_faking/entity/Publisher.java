package fr.poec.springboot.instant_faking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.PublisherShowView.class)
    private Long id;

    @JsonView(JsonViews.PublisherShowView.class)
    private Date createdAt;

    @JsonView(JsonViews.PublisherShowView.class)
    private String name;

    @JsonView(JsonViews.PublisherShowView.class)
    private String slug;

    @JsonView(JsonViews.PublisherShowView.class)
    private String website;

    @ManyToOne
    @JsonView(JsonViews.PublisherShowView.class)
    private Country country;

    @OneToMany(mappedBy = "publisher")
    @JsonView(JsonViews.PublisherShowView.class)
    private List<Game> games = new ArrayList<>();

}