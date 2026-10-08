<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>State Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>We received "${field}" and we are going to keep it across
		requests...</h3>
	<form action="retrieve_state_management" method="post">
		<input type="hidden" name="field" value="${field}">
		<input type="submit"
			value="click to pass state as hidden parameter in form">
	</form>
</body>
</html>
