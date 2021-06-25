<%@page import="com.ssi.Product"%>
<%
	Product product=(Product)session.getAttribute("details");
%>
<html>
<body>
	<h3>Product Details</h3>
	<hr>
	<table border="2">
		<tr>
			<td>Code</td>
			<td><%=product.getPcode() %></td>
		<tr>
		<tr>
			<td>Name</td>
			<td><%=product.getPname() %></td>
		<tr>
		<tr>
			<td>Price</td>
			<td><%=product.getPrice() %></td>
		<tr>
		<tr>
			<td>Disc</td>
			<td><%=product.getDiscount() %></td>
		<tr>
	</table>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>