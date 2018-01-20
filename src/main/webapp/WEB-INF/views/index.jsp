<%-- 
    Document   : index
    Created on : Jan 18, 2018, 10:18:33 PM
    Author     : Sumit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${pageContext.request.remoteUser}</h1>
        <form action="${pageContext.request.contextPath}/signout" method="post">
            <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
            <button type="submit" class="btn">Log out</button>
        </form>
    </body>
    
</html>
