<%-- 
    Document   : project
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:forEach items="${content}" var="test">
    <div class="col-xs-12 col-sm-6 col-lg-4">
	<div class="text-center">
	    <h1>
		${test.getHeader()}
	    </h1>
	</div>
	<img src="/photo?image=${test.getImage()}" class="img-responsive img-rounded" /> 
	<br />
	${test.getBody()} 
	<div class="text-right">
	    <h4>
		${test.getFooter()}
	    </h4>
	</div>
    </div>
</c:forEach>