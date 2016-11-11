<%-- 
    Document   : crew
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:forEach items="${content}" var="test">
    <div class="col-xs-12 col-sm-6 col-lg-4">
	<div class="text-center">
	    <h1>
		${test.getHeader()}
	    </h1>
	</div>
	<div class="col-sm-4 col-xs-4">
	    <img src="/photo?image=${test.getImage()}" class="img-responsive img-rounded" /> 
	</div>
	<div class="col-sm-8 col-xs-8">
	    ${test.getBody()} 
	</div>
	<div class="text-right">
	    <h4>
		${test.getFooter()}
	    </h4>
	</div>
	<sec:authorize access="hasRole('ADMIN')">
	    <form action="/crew/edit/${test.getId()}" method="GET">
		<button type="submit" class="btn btn-default btn-lg">
		    <span class="glyphicon glyphicon-ok" aria-hidden="true" />
		</button>
	    </form>
	    <form action="/crew/delete/${test.getId()}" method="GET">
		<button type="submit" class="btn btn-default btn-lg">
		    <span class="glyphicon glyphicon-remove" aria-hidden="true" />
		</button>
	    </form>
	</sec:authorize>
    </div>
</c:forEach>

<sec:authorize access="hasRole('ADMIN')">
    <div class="col-xs-12 col-sm-6 col-lg-4">
	<form action="/crew/add" method="GET">
	    <button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" >
	    </button>
	</form>
    </div>
</sec:authorize>