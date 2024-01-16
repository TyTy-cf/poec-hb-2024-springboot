<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <h1>${user.name}</h1>
</div>

<%@ include file="../footer.jsp" %>
