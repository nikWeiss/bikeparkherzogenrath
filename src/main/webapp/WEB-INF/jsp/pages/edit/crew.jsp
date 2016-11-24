<%-- 
    Document   : crew
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-xs-12 col-sm-12 col-lg-12">
    <sec:authorize access="hasRole('ADMIN')">
	<form:form action="/crew/add/" method="POST" modelAttribute="crew">
	    <div class="container card card-container">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<form:input type="hidden" value="${test.getId()}" path="id" />
		<div class="form-group">
		    <form:label path="header">Header</form:label>
		    <form:input path="header" value="${crew.getHeader()}" class="form-control" />
		</div>
		<div class="form-group">
		    <form:label path="body">Body</form:label>
		    <form:textarea path="body" value="${crew.getBody()}" class="form-control" />
		</div>
		<div class="form-group">
		    <form:label path="footer">Footer</form:label>
		    <form:input path="footer" value="${crew.getFooter()}" class="form-control" />
		</div>
		<div class="form-group">
		    <form:label path="image">Bild</form:label>
		    <form:textarea path="image" value="${crew.getImage()}" class="form-control" />
		</div>

		<button type="button submit" class="btn btn-default btn-lg">
		    <span class="glyphicon glyphicon-ok" aria-hidden="true" />
		</button>
	    </div>
	</form:form>
    </sec:authorize>
</div>