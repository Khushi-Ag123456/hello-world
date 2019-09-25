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
		<form:form modelAttribute="loginEmployee" action="/login" name = "loginEmployee">
			<form:errors name="loginEmployee" />
			<h1>Login</h1>
			<h4>${errorMsg}</h4>
			<table cellspacing="20px">
				<tr>
					<td><form:label path="emailId">Email Id : </form:label></td>
					<td><form:input path="emailId"
							placeholder="i.e anu@gmail.com" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:password path="password"
							placeholder="Enter password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Login" />
		</form:form>
	</div>

</body>
</html>