<%-- 
    Document   : crew
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-xs-12 col-sm-6 col-lg-4">
    <sec:authorize access="hasRole('ADMIN')">
	<form:form action="/crew/add/" method="POST" modelAttribute="crew">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="hidden" value="${test.getId()}" name="id" />
	    <div class="form-group">
		<form:label path="header">Header</form:label>
		<form:input path="header" />
	    </div>
	    <div class="form-group">
		<form:label path="body">Body</form:label>
		<form:input path="body" />
	    </div>
	    <div class="form-group">
		<form:label path="footer">Footer</form:label>
		<form:input path="footer" />
	    </div>
	    <div class="form-group">
		<label path="image">Bild</label>
		<form:input path="image" />
	    </div>

	    <button type="button submit" class="btn btn-default btn-lg">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true" />
		Hinzufügen
	    </button>
	</form:form>
    </sec:authorize>
</div>