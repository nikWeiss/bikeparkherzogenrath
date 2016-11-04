<%-- 
    Document   : navbar
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
	<div id="navbar" class="navbar">
	    <ul class="nav navbar-nav">
		<c:forEach items="${leftNavigation}" var="nav">
		    <sec:authorize access="${nav.getAuthorization()}">
			<li>
			    <a href="${nav.getLink()}">${nav.getName()}</a>
			</li>
		    </sec:authorize>
		</c:forEach>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">

		<sec:authorize access="!isAuthenticated()">
		    <li>
			<a href="login">Login</a>
		    </li>
		    <li>
			<a href="register">Register</a>
		    </li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
		    <li>
			<a><sec:authentication property="principal.username" /></a>
		    </li>
		    <li>
			<a href="logout">Logout</a>
		    </li>
		</sec:authorize>
	    </ul>
	</div>
    </div>
</nav>
