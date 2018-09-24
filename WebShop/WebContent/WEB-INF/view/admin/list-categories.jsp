<%@include file="top.jsp" %>
        
        <div id="wrapper">
		<div id="header">
			<h2>Admin - Categories<h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<input type="button" value="Add Categories"
				   onclick="window.location.href='add'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Category name </th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCategory" items="${categories}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="update">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="delete">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCategory.name} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>

<%@include file="botton.jsp" %>
    