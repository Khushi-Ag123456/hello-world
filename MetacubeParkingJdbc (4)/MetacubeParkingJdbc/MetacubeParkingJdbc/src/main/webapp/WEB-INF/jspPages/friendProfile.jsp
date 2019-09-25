<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div align='center'>
		<form:form modelAttribute = "friend">
			<h1>Profile</h1>
			<table>
				<tr>
					<td>FullName :</td>
					<td>${friend.fullName}</td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>${friend.gender}</td>
				</tr>
				<tr>
					<td>EmailId :</td>
					<td>${friend.emailId}</td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td>${friend.contactNumber}</td>
				</tr>
				<tr>
					<td>Organization :</td>
					<td>${friend.organization}</td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>