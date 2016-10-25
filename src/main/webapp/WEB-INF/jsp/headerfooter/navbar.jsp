<%-- 
    Document   : navbar
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
	<div id="navbar" class="navbar">
	    <ul class="nav navbar-nav">
		<c:forEach items="${leftNavigation}" var="nav">
		    <li><a href="${nav.getLink()}">${nav.getName()}</a></li>
		</c:forEach>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
		<li><a href="login">Login</a></li>
		<li><a href="register">Register</a></li>
	    </ul>
	</div>
    </div>
</nav>
