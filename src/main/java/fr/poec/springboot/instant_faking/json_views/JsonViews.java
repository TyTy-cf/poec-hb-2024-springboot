package fr.poec.springboot.instant_faking.json_views;

public class JsonViews {

    public interface GameListView {}

    public interface CountryDetailView {}

    public interface PublisherShowView extends GameListView, CountryDetailView {}

    public interface UserShowView extends GameListView, CountryDetailView {}

    public interface UserMinimalView {}

    public interface ReviewListView extends GameListView, UserMinimalView {}

}
