<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Platforms"/>
<jsp:include flush="true" page="base_admin.jsp"/>

<div class="container">
    <h1>Bonjour ${loggedUser.name} !</h1>

    <div class="row">
        <div class="col-lg-6 col-sm-12">
            <h2>Les dernières inscriptions :</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Le</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lastUsers}" var="user">
                    <tr>
                        <td>${user.createdAt}</td>
                        <td>${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6 col-sm-12">
            <h2>Les dernières inscriptions :</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Le</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lastUsers}" var="user">
                    <tr>
                        <td>${user.createdAt}</td>
                        <td>${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6 col-sm-12">
            <h2>Les dernières inscriptions :</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Le</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lastUsers}" var="user">
                    <tr>
                        <td>${user.createdAt}</td>
                        <td>${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-6 col-sm-12">
            <h2>Les dernières inscriptions :</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Le</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lastUsers}" var="user">
                    <tr>
                        <td>${user.createdAt}</td>
                        <td>${user.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@ include file="footer_admin.jsp" %>
