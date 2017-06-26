<%-- 
    Document   : crew
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="count" value="0" />
<div class="container">
    <sec:authorize access="hasRole('ADMIN')">
	<div class="row col-xs-12">
	    <form action="/crew/add" method="GET">
		<button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" />
	    </form>
	</div>
    </sec:authorize>

    <c:forEach items="${content}" var="test">

	<div class="card">
	    <div class="card-block">
		<h1 class="card-title">
		    ${test.getHeader()}
		</h1>
	    </div>
	    <div class="card-block">
		<c:if test="${test.isImageSet()}">
		    <div class="col-sm-6 col-xs-5">
			<img src="/image?image=${test.getImage()}" class="img-responsive img-rounded" /> 
		    </div>
		</c:if>
		<div class="col-sm-6 col-xs-7">
		    ${test.getBody()} 
		</div>
	    </div>
	    <div class="card-block">
		<p class="card-text">${singleContent.getBody()}</p>
		<div class="text-right">
		    <p class="card-text">${test.getFooter()}</p>
		</div>
	    </div>
	    <sec:authorize access="hasRole('ADMIN')">
		<table>
		    <tr>
			<td>
			    <form action="/crew/edit/${test.getId()}" method="GET">
				<button type="submit" class="btn btn-warning btn-lg glyphicon glyphicon-edit" />
			    </form>
			</td>
			<td>
			    <form action="/crew/delete/${test.getId()}" method="GET">
				<button type="submit" class="btn btn-danger btn-lg glyphicon glyphicon-remove" />
			    </form>
			</td>
		    </tr>
		</table>
	    </sec:authorize>
	</div>

    </c:forEach>
</div>