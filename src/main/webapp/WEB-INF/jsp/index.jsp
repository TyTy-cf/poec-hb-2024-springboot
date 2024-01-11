<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
    <head>
        <title>Instant-Faking</title>
        <link href="<c:url value="../../css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="../../css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Instant-Faking</h1>
            <h2 class="my-5">Les dernières sorties</h2>
            <div class="row">
                <c:forEach items="${gamesReleased}" var="game">
                    <a class="col-4 mt-2 main-game-card" href="/game/show/${game.slug}">
                        <div class="game-card">
                            <div class="game-card-img">
                                <img src="${game.thumbnailCover}">
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>${game.name}</p>
                                <p>${game.price}€</p>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
