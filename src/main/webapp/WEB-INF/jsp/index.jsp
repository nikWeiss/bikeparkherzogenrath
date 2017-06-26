<%-- 
    Document   : index
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<f:view>
    <html>
	<jsp:include page="headerfooter/header.jsp" />

        <body>
	    <jsp:include page="headerfooter/navbar.jsp" flush="true" />
	    <jsp:include page="pages/${site}.jsp" flush="true" />
	</body>
	<jsp:include page="headerfooter/footer.jsp" />
    </html>
</f:view>
