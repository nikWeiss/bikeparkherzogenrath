<%-- 
    Document   : jsp-spring-boot
    Created on : 15.10.2016, 20:26:06
    Author     : Niklas
--%>

<html>
    <head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<title>
	    Test Page
	</title>
    </head>
    <body>
	<h1>
	    Browser Parameters
	</h1>

	Your browser is: <%= request.getHeader("User-Agent") %>
	<br />
	Your IP address is: <%= request.getRemoteAddr() %>

    </body>
</html>