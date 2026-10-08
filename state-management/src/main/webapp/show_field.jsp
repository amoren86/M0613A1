<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>
		We received "${field}" using
		<c:choose>
			<c:when test="${stateManagementMethod eq 'URL_REWRITE'}">url rewrite</c:when>
			<c:when test="${stateManagementMethod eq 'HIDDEN_FIELD'}">hidden field</c:when>
			<c:when test="${stateManagementMethod eq 'COOKIE'}">cookie</c:when>
			<c:when test="${stateManagementMethod eq 'SESSION'}">session</c:when>
			<c:otherwise>??</c:otherwise>
		</c:choose>
	</h3>
	<p>
		<a href="enter_field.jsp">click to go back to the form</a>
	</p>
</body>
</html>
