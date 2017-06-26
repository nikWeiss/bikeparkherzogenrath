<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<div class="carousel-item active view hm-black-light" style="background-image: url('/image/large?image=/title/header.jpeg'); background-repeat: no-repeat; background-size: cover;">
    <div class="full-bg-img flex-center white-text ">
        <img class="img-rounded col-xs-4" src="/image/large?image=/title/logo.jpg" />
    </div>
</div>

<br />

<div class="container">
    <c:forEach items="${content}" var="singleContent">
        <div class="row"> 
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
            </div>
        </div>
	<br />
    </c:forEach>
</div>