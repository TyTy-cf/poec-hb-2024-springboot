package fr.poec.springboot.instant_faking.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.poec.springboot.instant_faking.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @JsonView(JsonViews.PublisherShowView.class)
    private String name;

    private String nationality;

    @JsonView(JsonViews.PublisherShowView.class)
    private String slug;

    @JsonView(JsonViews.PublisherShowView.class)
    private String urlFlag;

}