<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<f:view>
    <html>
	<%@ include file="headerfooter/header.jsp" %>

        <body>
	    <div class="container container-fluid">
		<jsp:include page="headerfooter/navbar.jsp" flush="true" />
		<jsp:include page ="pages/${site}.jsp" flush="true" />
	    </div>
	</body>
    </html>
</f:view>
