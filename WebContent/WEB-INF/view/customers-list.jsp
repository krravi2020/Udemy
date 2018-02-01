<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>			
		</div>
			
		
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='addForm';return false;"/ >
			<br><br><br>
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<tr>
						<td> ${tempCustomer.first_name} </td>
						<td> ${tempCustomer.last_name} </td>
						<td> ${tempCustomer.email} </td>
						<td> <a href="${updateLink}">Update</a> <a href="${deleteLink}" onclick="if(!(confirm('Are you sure ?')))return false">Delete</a> </td>
					</tr>
				
				</c:forEach>
		
			</table>
				
		</div>
	
	</div>
	

</body>

</html>

<%-- <!DOCTYPE html>
<html>
<head>
	<title>Customers List</title>
</head>
<body>
${customers}
</body>
</html> --%>