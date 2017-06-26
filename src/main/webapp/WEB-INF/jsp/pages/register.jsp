<%-- 
    Document   : register
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container center-block card">
    <form:form action="/register" method="POST" modelAttribute="user">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<div class="card-block">
	    <img id="profile-img" class="profile-img-card center-block" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	</div>
	<p class="card-text">Username</p>
	<div class="form-group">
	    <form:input path="username" value="${user.getUsername()}" class="form-control"/>
	</div>
	<p class="card-text">Password</p>
	<div class="form-group">
	    <form:password path="password" value="${user.getPassword()}" class="form-control"/>
	</div>
	<div class="card-block">
	    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" name="submit">Registrierung</button>
	    <c:if test="${message != null}">
		<h1>${message}</h1>
	    </c:if >
	</div>
    </form:form>
</div>
