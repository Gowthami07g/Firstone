<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="three" modelAttribute="emp">
		<p></p>
		<table align="center">
		<h1>Register </h1>
			<tr>
			<form:input path="empNo" type ="hidden" />
			
			<tr>

				<td>EmpName:</td>
				<td><form:input path="empName" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><form:input path="city" /></td>
			</tr>

			<tr>
				<td>PhoneNumber</td>
				<td><form:input path="phnoe" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save" /></td>
				
			</tr>
</table>
</form:form>
</body>
</html>