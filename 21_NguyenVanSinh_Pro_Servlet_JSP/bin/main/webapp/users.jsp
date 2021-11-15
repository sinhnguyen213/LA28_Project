<%@page import="com.luvina.servletjsp.logic.ListUserServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid #000;
	border-collapse: collapse;
}
</style>

</head>
<body>


	<jsp:useBean id="listUser" type="java.util.List" scope="session" />
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>Birthplace</th>
		</tr>
		<c:forEach items="${listUser}" var="user">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getName()}</td>
				<td>${user.getBirthday()}</td>
				<td>${user.getBirthPlace()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>