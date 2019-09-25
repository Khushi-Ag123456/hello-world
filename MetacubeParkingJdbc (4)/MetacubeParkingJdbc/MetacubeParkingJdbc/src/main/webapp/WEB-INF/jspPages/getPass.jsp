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


	<div align='center'>
		<form:form modelAttribute="pass" action = "/getPass">
			<p>1. Select Plans in (USD)</p>
			<form:select path = "plan">
				<form:options items="${passPrices}" />
			</form:select>
		<form:errors path="plan" />	
			</br>
			</br>

			<p>2. Do You Want To Change Currency</p>
			<form:select path= "currency" align='center'>
				<form:option value="USD">USD</form:option>
				<form:option value="INR">INR</form:option>
				<form:option value="YEN">YEN</form:option>
			</form:select>
			<input type='submit' value='GetPass' />
			</form:form>
	</div>
</body>
</html>