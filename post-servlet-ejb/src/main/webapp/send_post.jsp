<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Post</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="sections/header.jsp" />
   <h3>Write a message:</h3>
   <form action="post" method="post">
       <label for="email">E-mail:</label>
       <input id="email" type="text" name="email" />
       <p/><label for="age">Age:</label>
       <input id="age" type="number" name="age" min="0">
	   <p/><label for="message">Message:</label>
	   <textarea id="message" name="message" />
	    <input type="submit">
   </form>
</body>
</html>