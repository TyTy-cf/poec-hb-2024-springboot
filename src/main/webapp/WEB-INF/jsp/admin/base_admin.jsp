<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Admin - Instant-Faking";
    }
    request.setAttribute("title", title);
%>

<html>
<head>
    <title>${title}</title>
    <link href="${contextPath}/css/main.css" rel="stylesheet">
    <link href="${contextPath}/css/admin/admin.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
    <script type="text/javascript" src="${contextPath}/js/page/multiple-select.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-md-3 col-sm-12 menu-admin">
                <div class="me-3">
                    <div class="mb-5 mt-4 text-center">
                        <a class="navbar-brand ms-3" href="${contextPath}/">
                            <i class="fa-brands fa-steam fa-4x"></i>
                        </a>
                    </div>
                    <ul class="list-unstyled text-center menu-link">
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN}">Admin</a>
                    </li>
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN_GAME_NEW}">Game</a>
                    </li>
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN_GAME_NEW}">Publisher</a>
                    </li>
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN_GAME_NEW}">Category</a>
                    </li>
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN_GAME_NEW}">Country</a>
                    </li>
                    <li>
                        <a class="nav-link" href="${UrlRoute.URL_ADMIN_PLATFORM}">Platform</a>
                    </li>
                </ul>
                </div>
            </div>
            <div class="col-lg-10 col-md-9 col-sm-12 pt-4 admin-content">
