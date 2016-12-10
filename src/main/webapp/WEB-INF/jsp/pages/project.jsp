<%-- 
    Document   : project
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<c:set var="count" value="0" />

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
	    <c:forEach items="${test.getImageListArray()}" var="image">
		<img src="/image?image=${image}" class="img-responsive img-rounded" /> 
	    </c:forEach>
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

<sec:authorize access="hasRole('ADMIN')">
    <div class="col-xs-12 col-sm-6 col-lg-4">
	<form action="/project/add" method="GET">
	    <button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" />
	</form>
    </div>
</sec:authorize>