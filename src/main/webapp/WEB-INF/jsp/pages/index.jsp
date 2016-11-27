<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<div class="row">
    <img class="img-responsive img-rounded col-xs-4 col-sm-4 col-md-4 col-lg-4" src="/photo?image=/title/logo.jpg" />
    <img class="img-responsive img-rounded col-xs-8 col-sm-8 col-md-8 col-lg-8" src="/photo?image=/title/header.jpeg" />
</div>
<c:forEach items="${content}" var="test">
    <div class="row">
	<div class="text-center">
	    <h1>
		${test.getHeader()}
	    </h1>
	</div>
	<c:if test="${test.isImageSet()}">
	    <img src="/photo?image=${test.getImage()}" class="img-responsive img-rounded" /> 
	</c:if>
	<c:if test="${test.isImageListSet()}">
	    <c:forEach items="${test.getImageListArray()}" var="image">
		<img src="/photo?image=${image}" class="img-responsive img-rounded" /> 
	    </c:forEach>
	</c:if>
	<br />
	${test.getBody()} 
	<div class="text-right">
	    <h4>
		${test.getFooter()}
	    </h4>
	</div>
    </div>
</c:forEach>