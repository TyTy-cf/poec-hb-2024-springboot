<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${game.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-6">
            <div class="container-img p-3">
                <img alt="${game.name}" src="${game.thumbnailCover}">
            </div>
        </div>
        <div class="col-6">
            <h1>${game.name}</h1>
            <div class="d-flex">
                <c:forEach items="${game.countries}" var="country">
                    <img class="me-1"
                         src="${country.urlFlag}"
                         alt="${country.name}"
                         title="${country.nationality}"
                    >
                </c:forEach>
            </div>
            <c:if test="${game.platforms.size() > 0}">
                <p class="m-0">Disponible sur :</p>
                <ul class="list-unstyled">
                    <c:forEach items="${game.platforms}" var="platform">
                        <li>${platform.name}</li>
                    </c:forEach>
                </ul>
            </c:if>
            <p>${game.price}€</p>
        </div>
    </div>

    <h2 class="my-5">Description</h2>

    <div class="text-center">
        <c:out value="${game.description}" escapeXml="false"/>
    </div>

    <c:if test="${game.reviews.size() > 0}">
        <h2 class="my-5">Commentaires</h2>
        <div class="row">
            <c:forEach items="${game.reviews.subList(0, 12)}" var="review">
                <div class="col-3">
                    <div>${review.rating}/5</div>
                </div>
            </c:forEach>
        </div>
    </c:if>

<%--    TODO : form commentaire ?--%>

</div>

<%@ include file="../footer.jsp" %>
