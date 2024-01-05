package fr.poec.springboot.instant_faking.json_views;

public class JsonViews {

    public interface GameListView {}

    public interface GameShowView extends GameListView { }

    public interface CountryDetailView {}

    public interface PublisherShowView extends GameListView, CountryDetailView {}

    public interface UserShowView extends GameListView, UserListView, ReviewShowView {}

    public interface UserMinimalView {}

    public interface UserListView extends UserMinimalView, CountryDetailView {}

    public interface ReviewShowView {}

    public interface ReviewListView extends GameListView, UserMinimalView, ReviewShowView, GameShowView, UserListView {}

}
