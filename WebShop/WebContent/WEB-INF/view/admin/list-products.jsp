<%@include file="top.jsp" %>
	<div id="wrapper">
		<div id="header">
		<h2>Admin - Products<h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Product -->
		
			<input type="button" value="Add Product"
				   onclick="window.location.href='add'; return false;"
				   class="add-button"/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Title</th>
					<th>Price</th>
					<th>Availability</th>
					<th>Image</th>
				</tr>
				<!-- loop over and print our products -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- construct an "update" link with product id -->
					<c:url var="updateLink" value="update">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					

					<!-- construct an "delete" link with product id -->
					<c:url var="deleteLink" value="delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					
										
					<tr>
						<td> ${tempProduct.title} </td>
						<td> ${tempProduct.price} </td>
						<td> ${tempProduct.availability} </td>
						<td> <img src="${tempProduct.image}" width="244" height="244"></td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
<%@include file="botton.jsp" %>








