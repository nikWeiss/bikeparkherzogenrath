<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<div class="col-xs-12">
    <div class="row well">
	<img class="img-responsive img-rounded col-xs-4 col-sm-4 col-md-4 col-lg-4" src="/image/large?image=/title/logo.jpg" />
	<img class="img-responsive img-rounded col-xs-8 col-sm-8 col-md-8 col-lg-8" src="/image/large?image=/title/header.jpeg" />
    </div>
    <c:forEach items="${content}" var="test">
	<div class="row well">
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
	    <div>
		${test.getBody()} 
	    </div>
	    <div class="text-right">
		<h4>
		    ${test.getFooter()}
		</h4>
	    </div>
	</div>
    </c:forEach>
</div>