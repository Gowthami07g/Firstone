<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>View Customer</title>
</head>
<body>
	<div align="center" class="table-responsive">
		<form:form action="update" name="form1" modelAttribute="emp">
								
			<table class="table table-bordered table-sm"
				style="width: 50%; margin-left: 200px;">
				<tr>
					<th>EmpId:</th>
					<th>EmpName:</th>
					<th>City</th>
					<th>Mobile Number</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach var="customer" items="${list}">
					<c:choose>

						<c:when test="${customer.empNo==editCustlist}">

							
								<td><form:hidden path="empNo"/></td>
								<td><form:input path="empName" value="${customer.empName}" /></td>
								<td><form:input path="city" value="${customer.city}" /></td>
								<td><form:input path="phnoe" value="${customer.phnoe}" /></td>
								<td><a href="#" onclick="form1.submit()" ><img src="/images/update.jpg"height="20" width="20"></a></td>
								
								
						
						</c:when>
						<c:otherwise>
							<tr>
								<td>${customer.empNo}</td>
								<td>${customer.empName}</td>
								<td>${customer.city}</td>
								<td>${customer.phnoe}</td>
								<td><a href="Edit?empNo=${customer.empNo}"><img src="/images/edit.jpg" height="20" width="20"></a></td>
								<td><a href="Delete?empNo=${customer.empNo}"><img src="/images/delete.jpg" height="20" width="20"></a></td>
							</tr>
							</c:otherwise>
							</c:choose>
						</c:forEach>
			</table>
			</form:form>
	</div>
</body>
</html>