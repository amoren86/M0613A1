<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Error</title>
</head>
<body>
	<jsp:include page="sections/header.jsp" />
	<h3>Invalid user name or password.</h3>
	<c:url var="url" value="/library" />
	<p>Please enter a user name or password that is authorized to
		access this application</p>
	<p>
		Go to the <a href="http://localhost:4848">Admin Console</a>, select
		<code>
			Configurations &gt; server-config &gt; Security &gt; Realms &gt; <a
				href="http://localhost:4848/common/security/realms/realmEdit.jsf?name=file&configName=server-config">file</a>
		</code>
	</p>
	<p>
		Click on
		<button>Manage Users</button>
		button and then on
		<button>New...</button>
		button and create a user of GroupList
		<code>user</code>
		or
		<code>librarian</code>
	</p>
	<p>
		Click here to <a href="${url}">Try Again</a>
	</p>
</body>
</html>