<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	

<div class="carousel-item active view hm-black-light" style="background-image: url('/image/large?image=/title/header.jpeg'); background-repeat: no-repeat; background-size: cover;">
    <div class="full-bg-img flex-center white-text ">
        <img class="img-rounded col-xs-4 col-sm-4 col-md-4 col-lg-4" src="/image/large?image=/title/logo.jpg" />
    </div>
</div>
<br />
<div class="container">
    <c:forEach items="${content}" var="test">
        <div class="row">
            <div class="card" style="width: 100%;">
                <div class="card-block">
                    <h1 class="card-title">
                        ${test.getHeader()}
                    </h1>
                </div>
                <c:if test="${test.isImageSet()}">
                    <img src="/image?image=${test.getImage()}" class="img-responsive img-rounded img-wide" /> 
                </c:if>
                <c:if test="${test.isImageListSet()}">
                    <div id="carousel-${test.getId()}" class="carousel slide carousel-fade white-text" data-ride="carousel" data-interval="false">
                        <ol class="carousel-indicators">
                            <c:set var="imgcnt" value="0" />
                            <c:forEach items="${test.getImageListArray()}" var="image">
                                <li data-target="#carousel-${test.getId()}" data-slide-to="${imgcnt}" />
                                <c:set var="imgcnt" value="${imgcnt+1}" />
                            </c:forEach>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <c:set var="imgcnt" value="0" />
                            <c:forEach items="${test.getImageListArray()}" var="image">
                                <c:if test="${imgcnt == 0}">
                                    <div class="carousel-item active view hm-black-light" style="background-image: url('/image?image=${image}'); background-repeat: no-repeat; background-size: cover;" alt="${image}">
                                    </div> 
                                </c:if>
                                <c:if test="${imgcnt != 0}">
                                    <div class="carousel-item view hm-black-light" style="background-image: url('/image?image=${image}'); background-repeat: no-repeat; background-size: cover;" alt="${image}">
                                    </div>
                                </c:if>
                                <c:set var="imgcnt" value="${imgcnt+1}" />
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev" href="#carousel-${test.getId()}" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carousel-${test.getId()}" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </c:if>

                <div class="card-block">
                    <p class="card-text">${test.getBody()}</p>
                    <div class="text-right">
                        <p class="card-text">${test.getFooter()}</p>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>