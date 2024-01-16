package fr.poec.springboot.instant_faking.mapping;

public interface UrlRoute {

    String URL_LOGIN = "/login";
    String URL_REGISTER = "/register";

    String URL_GAME = "/game";
    String URL_GAME_SEARCH = URL_GAME + "/search";

    String URL_ADMIN = "/admin";
    String URL_ADMIN_PLATFORM = URL_ADMIN + "/platform";
    String URL_ADMIN_PLATFORM_NEW = URL_ADMIN_PLATFORM + "/new";
    String URL_ADMIN_PLATFORM_EDIT = URL_ADMIN_PLATFORM + "/edit";

}
