<%@include file="top.jsp" %>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Product Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Product</h3>
	
		<form:form action="save" modelAttribute="product" method="POST">

			<!-- need to associate this data with product id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
				
					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>

					<tr>
						<td><label>Availability:</label></td>
						<td><form:input path="availability" /></td>
					</tr>

					<tr>
						<td><label>Image:</label></td>
						<td><form:input path="image" /></td>
					</tr>

					<tr>
						<td><label>Category:</label></td>
						<td><select name="category">
						<c:forEach items="${categories}" var="categories">
							<option value="${categories.id}">${categories.name}</option>
						</c:forEach>
						</select></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admin/product/list">Back to List</a>
		</p>
	
	</div>

<%@include file="botton.jsp" %>









