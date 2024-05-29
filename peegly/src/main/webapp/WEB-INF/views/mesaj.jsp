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
<f:form action="newmesaj" method="post" commandName="mesaj">
		<f:hidden path="id" />
		<div>
			<f:label path="title">Başlık:</f:label>
			<f:input path="title" />
		</div>
		<div>
			<f:label path="message">Mesajınız:</f:label>
			<f:input path="message" />
		</div>
		<div>
			<f:button>Kaydet</f:button>
		</div>
	</f:form>
	
	<c:forEach items="${listmesaj}" var="mesaj">
            <div>${mesaj.title}</div>
            <div>${mesaj.message}</div>
            <div>${mesaj.owner.name}</div>
            <div>${mesaj.date}</div>
            <div>${mesaj.vote}</div>
            <div><a href="<c:url value='/voteadd/${mesaj.id}' />" >Vote</a></div>
            <div><a href="<c:url value='/newcomment/${mesaj.id}' />" >Comment</a></div>

    </c:forEach>
</body>
</html>