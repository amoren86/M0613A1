<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Library</title>
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Library</h3>
	<c:if test="${not empty pageContext.request.remoteUser}">
		<h4>Hello ${pageContext.request.remoteUser}!</h4>
		<a href="logout">logout</a>
	</c:if>

	<c:if test="${pageContext.request.isUserInRole('librarian')}">
		<p>Book catalogued: ${catalog}</p>
	</c:if>
	<p>Book ${book} is ${availability ? '' : 'not'} available</p>
	<p style="color: red">${error}</p>
</body>
</html>