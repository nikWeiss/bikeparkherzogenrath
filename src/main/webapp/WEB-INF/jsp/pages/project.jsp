<%-- 
    Document   : project
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<c:url var="firstUrl" value="/project/1" />
<c:url var="lastUrl" value="/project/${deploymentLog.totalPages}" />
<c:url var="prevUrl" value="/project/${currentIndex - 1}" />
<c:url var="nextUrl" value="/project/${currentIndex + 1}" />

<c:set var="count" value="0" />
<div class="container">
    <sec:authorize access="hasRole('ADMIN')">
        <div class="row col-xs-12">
            <form action="/project/add" method="GET">
                <button class="btn btn-default btn-lg glyphicon glyphicon-plus" type="submit" />
            </form>
        </div>
    </sec:authorize>

    <c:forEach items="${content.getContent()}" var="singleContent">
	<div class="container row">
	    <div class="card" style="width: 100%;">
		<div class="card-block">
		    <h1 class="card-title">
			${singleContent.getHeader()}
		    </h1>
		</div>
		<c:if test="${singleContent.isImageSet()}">
		    <img src="/image?image=${singleContent.getImage()}" class="img-responsive img-rounded img-wide" /> 
		</c:if>

		<c:if test="${singleContent.isImageListSet()}">
		    <div id="carousel-${singleContent.getId()}" class="carousel slide carousel-fade" data-ride="carousel" data-interval="false">
			<ol class="carousel-indicators">
			    <c:set var="imgcnt" value="0" />
			    <c:forEach items="${singleContent.getImageListArray()}" var="image">
				<li data-target="#carousel-${singleContent.getId()}" data-slide-to="${imgcnt}" />
				<c:set var="imgcnt" value="${imgcnt+1}" />
			    </c:forEach>
			</ol>
			<div class="carousel-inner" role="listbox">
			    <c:set var="imgcnt" value="0" />
			    <c:forEach items="${singleContent.getImageListArray()}" var="image">
				<c:if test="${imgcnt == 0}">
				    <div class="carousel-item active">
					<img src="/image?image=${image}" class="img-wide">
				    </div>
				</c:if>
				<c:if test="${imgcnt != 0}">
				    <div class="carousel-item">
					<img src="/image?image=${image}" class="img-wide">
				    </div>
				</c:if>
				<c:set var="imgcnt" value="${imgcnt+1}" />
			    </c:forEach>
			</div>
			<a class="carousel-control-prev" href="#carousel-${singleContent.getId()}" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carousel-${singleContent.getId()}" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			</a>
		    </div>
		</c:if>

		<div class="card-block">
		    <p class="card-text">${singleContent.getBody()}</p>
		    <div class="text-right">
			<p class="card-text">${singleContent.getFooter()}</p>
		    </div>
		</div>

		<sec:authorize access="hasRole('ADMIN')">
		    <table>
			<tr>
			    <td>
				<form action="/project/edit/${singleContent.getId()}" method="GET">
				    <button type="submit" class="btn btn-warning btn-lg glyphicon glyphicon-edit" />
				</form>
			    </td>
			    <td>
				<form action="/project/delete/${singleContent.getId()}" method="GET">
				    <button type="submit" class="btn btn-danger btn-lg glyphicon glyphicon-remove" />
				</form>
			    </td>
			</tr>
		    </table>
		</sec:authorize>
	    </div>
	</div>
	<br />
    </c:forEach>

    <ul class="pager">
        <c:if test="${currentIndex > 1}">
            <li class="previous">
                <a href="/project/${currentIndex - 1}">Neuere</a>
            </li>
        </c:if>
        <c:if test="${currentIndex < content.totalPages}">
            <li class="next">
                <a href="/project/${currentIndex + 1}">Ältere</a>
            </li>
        </c:if>
    </ul>

</div>