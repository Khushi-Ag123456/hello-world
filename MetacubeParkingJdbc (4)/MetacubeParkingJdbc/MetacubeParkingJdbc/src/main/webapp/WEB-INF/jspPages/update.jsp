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
		document.getElementById("updateEmployee").reset();
	}
});
</script>
</head>
<body>
<div align = "right">
<a href='/logout'>LogOut</a>
</div>
	<div align="center">
		<form:form modelAttribute="employee" action="/update" method="post" id = "updateEmployee">
			
			<h1>Update Details</h1>
			<form:errors name="updateEmployee" />
			<h4>${errorMsg }</h4>
			<table cellspacing="20px">
				<tr>
					<td><form:label path="fullName">Full Name : </form:label></td>
					<td><form:input type="text" path="fullName" id = "fullName" value = "${employee.fullName}"
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
							placeholder="i.e anu@gmail.com" value = "${employee.emailId}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="emailId" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:input type="password" path="password" value = "${employee.password}"
							placeholder="Enter password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="confirmPassword">Confirm Password : </form:label></td>
					<td><form:input type="password" path="confirmPassword" value = "${employee.confirmPassword}"
							placeholder="Confirm your password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="confirmPassword" /></td>
				</tr>
				<tr>
					<td><form:label path="contactNumber">Contact No : </form:label></td>
					<td><form:input type="number" path="contactNumber" value = "${employee.contactNumber}"
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
			<input type="submit" value="Update" />
			</td>
		</form:form>
	</div>

</body>
</html>