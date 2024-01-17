<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <h1>
        ${user.name}
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <span class="text-danger">(ADMIN)</span>
        </security:authorize>
    </h1>
    <c:if test="${user.name == userLogged.name}">
        <p>Wallet : ${user.wallet}€</p>
    </c:if>
</div>

<%@ include file="../footer.jsp" %>
