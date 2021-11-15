<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@page import="com.luvina.servletjsp.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>

<style type="text/css">
table, th, td {
	border: 1px solid #000;
	border-collapse: collapse;
}

th, td {
	padding: 4px 8px;
}

</style>
</head>
<body>
	
	<div align="center">
		<h1>List User</h1>
	<h3>Code Java</h3>
	<table>
		<%--Tiêu đề bảng --%>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>BirthPlace</th>
		</tr>
		<%--Sử dụng java để add content cho table 
		- Lấy dữ liệu từ Servlet
		--%>
		<% List<UserBean> listUser = (ArrayList<UserBean>)session.getAttribute("listUser"); 
			
		%>
		<%--Vòng lặp for để in từng record ra bảng --%>
		<% for(int j = 0; j< listUser.size();j++){ 
			UserBean user = listUser.get(j);
		%>
		
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getBirthday()%></td>
				<td><%=user.getBirthPlace() %></td>
			</tr>
		<%} %>
	</table>
	
	<h3>JSTL</h3>
	<table>
		<%--Tiêu đề bảng --%>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>BirthPlace</th>
		</tr>
		<%--Vòng lặp forEach để in từng record ra bảng --%>
		<c:forEach items="${listUser }" var="user">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getName()}</td>
				<td>${user.getBirthday()}</td>
				<td>${user.getBirthPlace()}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>