<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <h1>
        <img class="me-1" src="${user.country.urlFlag}">
        ${user.name}
        <c:if test="${user.name == userLogged.name}">
            <button class="btn btn-link">
                <i class="fa-solid fa-pencil"></i>
            </button>
        </c:if>
    </h1>
    <jsp:useBean id="date" class="java.util.Date" />
    <p>Created at : <fmt:formatDate value="${userLogged.createdAt}" pattern="dd-MM-yyyy" /></p>
    <c:if test="${user.name == userLogged.name}">
        <p>Email : ${user.email}</p>
    </c:if>
    <p>Nickname : ${user.nickname}</p>
</div>

<%@ include file="../footer.jsp" %>
