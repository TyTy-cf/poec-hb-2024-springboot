<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>Instant-Faking</h1>

    <h2 class="my-5">Les derni&egrave;res sorties</h2>
    <div class="row">
        <c:forEach items="${gamesReleased}" var="game">
            <a class="col-4 mt-2 main-game-card" href="/game/${game.slug}">
                <div class="game-card">
                    <div class="game-card-img">
                        <img alt="${game.name}" src="${game.thumbnailCover}">
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

<%@ include file="footer.jsp" %>
