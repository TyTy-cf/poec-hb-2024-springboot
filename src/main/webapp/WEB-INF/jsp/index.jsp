<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Instant-Faking</title>
        <link href="<c:url value="../../css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            Coucou on est sur la home !
            <h1>Les dernières sorties</h1>
            <ul>
                <c:forEach items="${gamesReleased}" var="game">
                    <li>${game.name} - ${game.price}€</li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
