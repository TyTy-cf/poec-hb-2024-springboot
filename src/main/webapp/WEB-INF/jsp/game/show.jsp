<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>${game.name}</title>
        <link href="<c:url value="../../../css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="../../../css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>${game.name}</h1>

            <h2 class="my-5">Description</h2>

            <div class="text-center">
                <c:out value="${game.description}" escapeXml="false"/>
            </div>

        </div>
    </body>
</html>
