<%@include file="top.jsp" %>
        
        <div id="wrapper">
		<div id="header">
		<h2>Admin - Orders<h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			
			<table>
				<tr>
					<th>First name </th>
					<th>Last Name </th>
					<th>Email </th>
					<th>Address </th>
					<th>Order time </th>
				</tr>
				
				
				<c:forEach var="order" items="${order}">
				
					<tr>
						<td> ${order.firstName} </td>
						<td> ${order.lastName} </td>
						<td> ${order.email} </td>
						<td> ${order.address} </td>
						<td> ${order.ordertime} </td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>

<%@include file="botton.jsp" %>
    