<%-- 
    Document   : login
    Created on : Jan 20, 2018, 11:46:52 AM
    Author     : Sumit
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/signin" method="post">       
	<c:if test="${param.error != null}">        
            <p style="color: red">
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.signout != null}">       
            <p style="color:blue;">
			You have been logged out.
		</p>
	</c:if>
                <h3>Enter Login Credentials</h3>
            <p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>	
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>	
	</p>
        <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>
    </body>
</html>
