<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Instant-Faking";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="<c:url value="../../css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="../../css/main.css" />" rel="stylesheet">
    </head>
    <body>