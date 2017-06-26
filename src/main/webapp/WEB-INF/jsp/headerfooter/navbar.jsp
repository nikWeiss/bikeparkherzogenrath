<%-- 
    Document   : navbar
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-toggleable-md navbar-dark fixed-top blue">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" 
		type="button" 
		data-toggle="collapse" 
		data-target="#navbarNav1" 
		aria-controls="navbarNav1" 
		aria-expanded="false" 
		aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

	<a class="navbar-brand"  href="${brand.getLink()}">
	    <sec:authorize access="${brand.getAuthorization()}">
		<strong>${brand.getName()}</strong>
	    </sec:authorize>
	</a>

        <div class="collapse navbar-collapse" id="navbarNav1">
            <ul class="navbar-nav mr-auto">
                <c:forEach items="${leftNavigation}" var="nav">
                    <sec:authorize access="${nav.getAuthorization()}">
                        <li class="nav-item">
                            <a class="nav-link" href="${nav.getLink()}">${nav.getName()}</a>
                        </li>
                    </sec:authorize>
                </c:forEach>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" ><sec:authentication property="principal.username" /></a>
                    </li>
                </sec:authorize>
                <c:forEach items="${rightNavigation}" var="nav">
                    <sec:authorize access="${nav.getAuthorization()}">
                        <li class="nav-item">
                            <a class="nav-link" href="${nav.getLink()}">${nav.getName()}</a>
                        </li>
                    </sec:authorize>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>