<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
            <div>${mesaj1.title}</div>
            <div>${mesaj1.message}</div>
            <div>${mesaj1.owner.name}</div>
            <div>${mesaj1.date}</div>
            <f:form action="/add" method="post" commandName="yorum">
		<f:hidden path="id" />
		<div>
			<f:label path="comment">Yorumunuz:</f:label>
			<f:input path="comment" />
		</div>
		<div>
			<f:button>Kaydet</f:button>
		</div>
	</f:form>

</body>
</html>