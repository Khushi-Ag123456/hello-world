<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Home</title>
</head>
<body>
<div align = "right">
<a href='/logout'>LogOut</a>
</div>
<h1>Friends</h1>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${friends}" var="friend">

				<tr>
					<td>${friend.fullName}</td>
					<td><a href="friendProfile?email=${friend.emailId}">Profile</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>