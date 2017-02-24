<%-- 
    Document   : project
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<c:set var="count" value="0" />
<div>
    <sec:authorize access="hasRole('ADMIN')">
	<div class="row col-xs-12">
	    <form action="/project/add" method="GET">
		<button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" />
	    </form>
	</div>
    </sec:authorize>

    <c:forEach items="${content}" var="test">
	<c:if test="${(count mod 2) == 0}">
	    <div class="clearfix visible-xx"></div>
	</c:if>

	<div class="col-xs-12 col-sm-6 col-lg-6 well">
	    <div class="text-center">
		<h1>
		    ${test.getHeader()}
		</h1>
	    </div>
	    <c:if test="${test.isImageSet()}">
		<img src="/image?image=${test.getImage()}" class="img-responsive img-rounded" /> 
	    </c:if>
	    <c:if test="${test.isImageListSet()}">
		<div id="${test.getId()}" class="carousel">
		    <ol class="carousel-indicators">
			<c:forEach items="${test.getImageListArray()}" var="image">
			    <li data-target="#${test.getId()}" data-slide-to="${imgcnt}" />
			    <c:set var="imgcnt" value="${imgcnt+1}" />
			</c:forEach>
		    </ol>
		    <div class="carousel-inner" role="listbox">
			<c:set var="imgcnt" value="0" />
			<c:forEach items="${test.getImageListArray()}" var="image">
			    <c:if test="${imgcnt == 0}">
				<div class="item active">
				    <img src="/image?image=${image}" alt="${image}" />
				</div>
			    </c:if>
			    <c:if test="${imgcnt != 0}">
				<div class="item">
				    <img src="/image?image=${image}" alt="${image}"/>
				</div>
			    </c:if>
			    <c:set var="imgcnt" value="${imgcnt+1}" />
			</c:forEach>
		    </div>
		    <a class="left carousel-control" href="#${test.getId()}" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#${test.getId()}" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		    </a>
		</div>
	    </c:if>
	    <br />
	    ${test.getBody()} 
	    <div class="text-right">
		<h4>
		    ${test.getFooter()}
		</h4>
	    </div>
	    <sec:authorize access="hasRole('ADMIN')">
		<table>
		    <tr>
			<td>
			    <form action="/project/edit/${test.getId()}" method="GET">
				<button type="submit" class="btn btn-warning btn-lg glyphicon glyphicon-edit" />
			    </form>
			</td>
			<td>
			    <form action="/project/delete/${test.getId()}" method="GET">
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