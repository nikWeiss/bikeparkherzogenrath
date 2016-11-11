<%-- 
    Document   : crew
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-xs-12 col-sm-6 col-lg-4">
    <sec:authorize access="hasRole('ADMIN')">
	<form action="/crew/add/" method="POST">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="hidden" value="${test.getId()}" name="id" />
	    <div class="form-group">
		<label for="header">Header</label>
		<input type="text" class="form-control" id="header" />
	    </div>
	    <div class="form-group">
		<label for="body">Body</label>
		<input type="text" class="form-control" id="body" />
	    </div>
	    <div class="form-group">
		<label for="footer">Footer</label>
		<input type="text" class="form-control" id="footer" />
	    </div>
	    <div class="form-group">
		<label for="image">Bild</label>
		<input type="text" class="form-control" id="image" />
	    </div>

	    <button type="button submit" class="btn btn-default btn-lg">
		<span class="glyphicon glyphicon-pencil" aria-hidden="true" />
		Hinzufügen
	    </button>
	</form>
    </sec:authorize>
</div>