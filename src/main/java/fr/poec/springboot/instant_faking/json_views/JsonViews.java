package fr.poec.springboot.instant_faking.json_views;

public class JsonViews {

    public interface PublisherListView {}

    public interface GameListView {}

    public interface CountryDetailView {}

    public interface PublisherShowView extends GameListView, CountryDetailView {}

}
