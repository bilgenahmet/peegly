<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Login with E-mail and Password</h3>
	<f:form action="login" method="post" commandName="user">
		<div>
			<label for="username">Eposta:</label> <input type="email" name="username" />
		</div>
		<div>
			<label for="password">Şifre:</label> <input type="password" name="password" />
		</div>
		<div>
			<f:button>Giriş</f:button>
		</div>
		<div><input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /></div>
	</f:form>
</body>
</html>