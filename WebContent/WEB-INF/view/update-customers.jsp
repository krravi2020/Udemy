<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Update Customer</title>
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css ">
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">	  
	</head>
	<body>
			<div id="wrapper">
				<div id="header">
				<h2>Update Customer Form</h2>
				</div>
			</div>
			<div id="container">
				<h3>Enter the Details</h3>
				
				<form:form action="updateCustomer" modelAttribute="customers" method="POST" >
				
				<table>
				<tbody>
						<tr>
						<td><label>First Name :</label></td>
						<td><form:input path="first_name"></form:input></td>
						</tr>
						<tr>
						<td><label>Last Name :</label></td>
						<td><form:input path="last_name"></form:input></td>
						</tr>
						<tr>
						<td><label>Email  :</label></td>
						<td><form:input path="email"></form:input></td>
						</tr>
						<tr>
						<td><label></label></td>
						<td><input type="submit" value="Submit" class="save"></td>
						</tr>
				</tbody>
				</table>
				</form:form>			
				<div style="clear;both;">
					<p>
						<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
					</p>
				</div>
			</div>
	</body>
</html>