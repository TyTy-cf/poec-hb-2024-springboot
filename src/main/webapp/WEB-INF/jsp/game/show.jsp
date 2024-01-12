<%@ include file="../base.jsp" %>

<div class="container">
    <h1>${game.name}</h1>

    <h2 class="my-5">Description</h2>

    <div class="text-center">
        <c:out value="${game.description}" escapeXml="false"/>
    </div>

</div>

<%@ include file="../footer.jsp" %>
