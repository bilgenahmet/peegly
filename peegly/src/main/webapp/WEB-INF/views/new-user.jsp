<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yeni Kullanıcı</title>
</head>
<body>
	<f:form action="new" method="post" commandName="user">
		<f:hidden path="id" />
		<div>
			<f:label path="name">Ad soyad:</f:label>
			<f:input path="name" />
		</div>
		<div>
			<f:label path="email">Eposta:</f:label>
			<f:input path="email" />
		</div>
		<div>
			<f:label path="password">Şifre:</f:label>
			<f:password path="password" />
		</div>
		<div>
			<f:button>Kaydet</f:button>
		</div>
	</f:form>
</body>
</html>