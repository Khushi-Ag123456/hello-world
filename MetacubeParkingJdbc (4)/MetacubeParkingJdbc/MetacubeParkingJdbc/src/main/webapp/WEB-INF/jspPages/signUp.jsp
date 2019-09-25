<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
$( document ).ready(function() {
	if(document.getElementById("fullName").value) {
		document.getElementById("registerEmployee").reset();
	}
});
</script>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="employee" action="/signUp" method="post" id = "registerEmployee">
			
			<h1>Register yourself</h1>
			<form:errors name="registerEmployee" />
			<table cellspacing="20px">
				<tr>
					<td><form:label path="fullName">Full Name : </form:label></td>
					<td><form:input type="text" path="fullName"  id = "fullName"
							placeholder="Enter full name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="fullName" /></td>
				</tr>
				 <tr>
                        <td align='left'><form:label path = "gender"> Gender </form:label></td>
                        <td><label><form:radiobutton  path = "gender" value = "Male" checked = "true"/>Male</label>
                        <label><form:radiobutton  path = "gender" value = "Female" />Female</label>
                        <label><form:radiobutton  path = "gender" value = "Other" />Other</label></td>
                    </tr>
				<tr>
					<td><form:label path="emailId">Email Id : </form:label></td>
					<td><form:input type="text" path="emailId"
							placeholder="i.e anu@gmail.com" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:input type="password" path="password"
							placeholder="Enter password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="confirmPassword">Confirm Password : </form:label></td>
					<td><form:input type="password" path="confirmPassword"
							placeholder="Confirm your password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="confirmPassword" /></td>
				</tr>
				<tr>
					<td><form:label path="contactNumber">Contact No : </form:label></td>
					<td><form:input type="number" path="contactNumber"
							placeholder="Enter contact number" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="contactNumber" /></td>
				</tr>
				<tr>
                    	<td><form:label path = "organization">Organization : </form:label></td>
                    		<td><form:select path = "organization" >
                    			<form:option value = "finance">Finance</form:option>
                    			<form:option value = "Admin">Admin</form:option>
                    			<form:option value = "Canteen">Canteen</form:option>
                    			<form:option value = "Hr">HR</form:option>
                    			</form:select>
                    		</td>
                    </tr>
			</table>
			<input type="submit" value="Register" />
			<a href = "/login" >Login</a>
			</td>
		</form:form>
	</div>

</body>
</html>