<%@ include file="../base.jsp" %>

<div class="container">
    <h1>${game.name}</h1>

    <h2 class="my-5">Description</h2>

    <div class="text-center">
        <c:out value="${game.description}" escapeXml="false"/>
    </div>

    <h2 class="my-5">Commentaires</h2>
    <div class="row">
        <c:forEach items="${game.reviews.subList(0, 12)}" var="review">
            <div class="col-3">
                <div>${review.rating}/5</div>
            </div>
        </c:forEach>
    </div>

<%--    TODO : form commentaire ?--%>

</div>

<%@ include file="../footer.jsp" %>
