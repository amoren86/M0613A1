<%-- JSP Server-side Comment: Traditional JSP Syntax Overview --%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<%!
    // Declaration: Method defined at Servlet class level
    private String formatProductPrice(double price) {
        return String.format("%.2f €", price);
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Product Catalog - Traditional Syntax</title>
</head>
<body>
	<header>
		<h1>Catalog</h1>
		<p>An app by Institut Marianao</p>
	</header>
	<%-- Scriptlet: Java logic executed inside _jspService() --%>
	<%
        String storeName = "Tech Shop";
        Map<String, Double> products = new HashMap<>();
        products.put("Keyboard",30.99);
        products.put("Mouse",15.49);
        products.put("Monitor",150.00);
    %>

	<!-- HTML Header with JSP Expressions -->
	<h3>
		Welcome to
		<%= storeName %></h3>
	<p>
		Generated on:
		<%= new Date() %></p>

	<h4>Available Products</h4>

	<%-- Conditional logic using Scriptlets and HTML --%>
	<% if (products.isEmpty()) { %>
		<p>No products available at this moment.</p>
	<% } else { %>
	<ul>
		<%-- Loop using Scriptlets --%>
		<% for (Map.Entry<String, Double> product : products.entrySet()) { %>
			<li><strong><%= product.getKey() %></strong> - Price: <%= formatProductPrice(product.getValue()) %>
			</li>
		<% } %>
	</ul>
	<% } %>

</body>
</html>