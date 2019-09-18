<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<table border : 1px>
<thead>
	<tr>
	<td>First Name</td>
	<td>Last Name</td>
	<td>Father Name</td>
	<td>Email Id</td>
	<td>Class</td>
	<td>Age</td>
	</tr>
</thead>
<tbody>
	<c:forEach items = "${Students}" var = "student">
	
	<tr>
	<td>${student.firstName}</td>
	<td>${student.lastName}</td>
	<td>${student.fatherName}</td>
	<td>${student.emailId}</td>
	<td>${student.studentClass}</td>
	<td>${student.age}</td>
	</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>