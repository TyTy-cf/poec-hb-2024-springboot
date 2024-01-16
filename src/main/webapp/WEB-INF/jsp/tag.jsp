<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page import="fr.poec.springboot.instant_faking.mapping.UrlRoute" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="fr.poec.springboot.instant_faking.service.UserService" %>
<%@ page import="fr.poec.springboot.instant_faking.entity.User" %>

<%
    WebApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
    if (ctx != null) {
        UserService userService = ctx.getBean(UserService.class);
        if (request.getUserPrincipal() != null) {
            User user = userService.findByEmail(request.getUserPrincipal().getName());
            request.setAttribute("userLogged", user);
        }
    }
%>
