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
	Welcome<a href = "/fileUpload?email=${employee.emailId}" ><object data = "/images/${img}" height = "40px" ><image src = "/images/default.jpg" height = "40px"></image></object></a>${employee.fullName}
	&nbsp;&nbsp;<a href='/logout'>LogOut</a>
	
	</div>
	<div align='center'>
		<form:form modelAttribute = "employee" >
		<h4>${loggedMsg}</h4>
		<h4>${Msg}</h4>
			<h1>Profile</h1>
			<table>
				<tr>
					<td>FullName :</td>
					<td>${employee.fullName}</td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td>${employee.gender}</td>
				</tr>
				<tr>
					<td>EmailId :</td>
					<td>${employee.emailId}</td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td>${employee.contactNumber}</td>
				</tr>
				<tr>
					<td>Organization :</td>
					<td>${employee.organization}</td>
				</tr>
			</table>
			<a href='/update?email=${employee.emailId}'>Edit</a><br> 
			<a href='/friends?email=${employee.emailId}'>Friends</a><br> 
		</form:form>
	</div>
</body>
</html>