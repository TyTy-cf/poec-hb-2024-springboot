<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 col-sm-12">
            <h1>
                <img class="me-1" src="${user.country.urlFlag}">
                ${user.name}
                <c:if test="${user.name == userLogged.name}">
                    <button class="btn btn-link" data-edit-profile-button>
                        <i class="fa-solid fa-pencil"></i>
                    </button>
                </c:if>
            </h1>
            <p>Created at : <fmt:formatDate value="${user.createdAt}" pattern="dd-MM-yyyy" /></p>
            <c:if test="${user.name == userLogged.name}">
                <p>Email : ${user.email}</p>
            </c:if>
            <p>Nickname : ${user.nickname}</p>
        </div>
        <div class="col-md-6 col-sm-12">
            <c:if test="${user.name == userLogged.name}">
                <div class="d-none" data-edit-profile-form>
                <f:form modelAttribute="userPutDto" method="post" action="${uri}">
                    <div class="mb-3 row">
                        <f:label path="nickname" class="col-sm-2 col-form-label">Nickname</f:label>
                        <div class="col-sm-10">
                            <f:input type="text" cssClass="form-control" path="nickname"/>
                            <f:errors path="nickname" cssClass="invalid-feedback"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <f:label path="password" class="col-sm-2 col-form-label">Password</f:label>
                        <div class="col-sm-10">
                            <f:input type="password" cssClass="form-control" path="password"/>
                            <f:errors path="password" cssClass="invalid-feedback"/>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <f:label path="countryId" class="col-sm-2 col-form-label">Country</f:label>
                        <div class="col-sm-10">
                            <f:select path="countryId"
                                      items="${countries}"
                                      cssClass="form-select"
                                      itemLabel="name"
                                      itemValue="id"
                            >
                            </f:select>
                        </div>
                    </div>
                    <f:button class="btn btn-secondary" type="reset">Reset</f:button>
                    <f:button class="btn btn-primary">Submit</f:button>
                </f:form>
            </div>
            </c:if>
        </div>
    </div>
    <div class="row mt-2">
        <h2>Ses jeux</h2>
        <c:forEach items="${user.userOwnGames}" var="uog">
            <a class="col-md-4 mt-2 main-game-card" href="${UrlRoute.URL_GAME}/${uog.game.slug}">
                <div class="game-card">
                    <div class="game-card-img">
                        <img alt="${uog.game.name}" src="${uog.game.thumbnailCover}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${uog.game.name}</p>
                        <c:if test="${user.name != userLogged.name}">
                            <p>${uog.game.price}€</p>
                        </c:if>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="../footer.jsp" %>
