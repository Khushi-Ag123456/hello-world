<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="student" action="/signUp" method="post"
			name="addStudent">
			<form:errors name="addStudent" />
			<h4>${msg }</h4>
			<h1>Register a Student</h1>
			<table cellspacing="20px">
				<tr>
					<td><form:label path="firstName">First Name : </form:label></td>
					<td><form:input type="text" path="firstName"
							placeholder="Enter first name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name : </form:label></td>
					<td><form:input type="text" path="lastName"
							placeholder="Enter last name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="fatherName">Father's Name : </form:label></td>
					<td><form:input type="text" path="fatherName"
							placeholder="Enter father's name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="fatherName" /></td>
				</tr>
				<tr>
					<td><form:label path="emailId">Email Id : </form:label></td>
					<td><form:input type="text" path="emailId"
							placeholder="i.e. anu@gmail.com" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="studentClass">Class : </form:label></td>
					<td><form:input type="number" path="studentClass"
							placeholder="i.e. 12" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="studentClass" /></td>
				</tr>
				<tr>
					<td><form:label path="age">Age : </form:label></td>
					<td><form:input type="number" path="age"
							placeholder="Enter age" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="age" /></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
			</td>
		</form:form>
	</div>

</body>
</html>