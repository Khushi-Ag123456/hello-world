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
	$(document).ready(function() {
		if (document.getElementById("vehicleName").value) {
			document.getElementById("vehicleForm").reset();
		}
	});
</script>
</head>
<body>
	<div align='center' id='registerVehicle'>
		<h4>${msg}</h4>
		<h1>Register your vehicle</h1>
		<form:form modelAttribute="vehicle" id="vehicleForm"
			action="/registerVehicle">
			<form:errors name="vehicleForm"></form:errors>
			<table align='center' cellspacing="20px">
				<tr>
					<td><form:label path="vehicleName">Name : </form:label></td>
					<td><form:input path="vehicleName" id="vehicleName"
							placeholder="Enter vehicle name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="vehicleName" /></td>
				</tr>
				<tr>
					<td><form:label path="vehicleType">Type : </form:label></td>
					<td><form:select path="vehicleType" id="vehicleType">
							<form:option path="vehicleType" value="Cycle" selected="true">Cycle</form:option>
							<form:option path="vehicleType" value="Bike">Bike</form:option>
							<form:option path="vehicleType" value="Four_Wheeler">Four Wheeler</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="vehicleNo">Vehicle No : </form:label></td>
					<td><form:input path="vehicleNo" 
							placeholder="Enter vehicle number" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="vehicleNo" /></td>
				</tr>
				<tr>
					<td><form:label path="employeeId">Employee id : </form:label></td>
					<td><form:input type="number" path="employeeId" value = "${employeeId}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="employeeId" /></td>
				</tr>
				<tr>
					<td><form:label path="identification">Identification : </form:label></td>
					<td><form:textarea path="identification" />
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="identification"></form:errors></td>
				</tr>

			</table>
			<br>
			<input type="submit" value="Register Vehicle">
		</form:form>
	</div>
</body>
</html>