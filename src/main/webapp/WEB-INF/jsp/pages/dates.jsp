<%-- 
    Document   : dates
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="count" value="0" />
<div>
    <sec:authorize access="hasRole('ADMIN')">
	<div class="row cos-xs-12">
	    <form action="/dates/add" method="GET">
		<button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" />
	    </form>
	</div>
    </sec:authorize>
    
    <c:forEach items="${content}" var="test">
	<c:if test="${(count mod 2) == 0}">
	    <div class="clearfix visible-sm"></div>
	</c:if>
	<c:if test="${(count mod 3) == 0}">
	    <div class="clearfix visible-lg"></div>
	</c:if>

	<div class="col-xs-12 col-sm-6 col-lg-4 well">
	    <div class="row">
		<div class="text-center">
		    <h1>
			${test.getHeader()}
		    </h1>
		</div>
	    </div>
	    <div class="row">
		<c:if test="${test.isImageSet()}">
		    <div class="col-sm-4 col-xs-5">
			<img src="/image?image=${test.getImage()}" class="img-responsive img-rounded" /> 
		    </div>
		</c:if>
		<div class="col-sm-8 col-xs-7">
		    ${test.getBody()} 
		</div>
	    </div>
	    <div class="row">
		<div class="text-right">
		    <h3>
			${test.getFooter()}
		    </h3>
		</div>
	    </div>
	    <sec:authorize access="hasRole('ADMIN')">
		<table>
		    <tr>
			<td>
			    <form action="/dates/edit/${test.getId()}" method="GET">
				<button type="submit" class="btn btn-warning btn-lg glyphicon glyphicon-edit" />
			    </form>
			</td>
			<td>
			    <form action="/dates/delete/${test.getId()}" method="GET">
				<button type="submit" class="btn btn-danger btn-lg glyphicon glyphicon-remove" />
			    </form>
			</td>
		    </tr>
		</table>
	    </sec:authorize>
	</div>
	<c:set var="count" value="${count+1}" />
    </c:forEach>
</div>