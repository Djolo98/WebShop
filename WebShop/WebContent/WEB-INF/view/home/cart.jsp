<%@include file="header.jsp" %>
<table class="table table-striped alignmiddle">

  <tr>
  		<th></th>
        <th>Image</th>
        <th>Title</th>
        <th>Price</th>
        <th>Quantity</th>
        <th></th>
        <th>Subtotal</th>
  </tr>
    <c:forEach items="${products}" var="product">
    <tr>
    	<td style="text-align: center; vertical-align: middle;" ><button form="remove:${product.id}" type="submit" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>x</button>&nbsp;</td>
        <td style="text-align: center; vertical-align: middle;"><img src="${product.image}" width="93" height="95" alt="photo 1" class="left" /></td>
        <td style="text-align: center; vertical-align: middle;">${product.title}</td>
        <td style="text-align: center; vertical-align: middle;">$${product.price}</td>
        <td style="text-align: center; vertical-align: middle;">${product.quantity}</td>
        <td style="text-align: center; vertical-align: middle;">
            <form method="post" action="remove" id="remove:${product.id}">
			    <input type="hidden" name="id" value="${product.id}">
			</form>
			<form method="post" action="addone" id="addoneid:${product.id}">
			    <input type="hidden" name="id" value="${product.id}">
			    <input type="hidden" name="quantity" value="1">
		 	</form>
		 	<form method="post" action="removeone" id="removeone:${product.id}">
			    <input type="hidden" name="id" value="${product.id}">
			    <input type="hidden" name="quantity" value="1">
		 	</form>
		 	
      		<button form="addoneid:${product.id}" type="submit" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-plus"></span>+</button>&nbsp;
        	<button form="removeone:${product.id}" type="submit" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-minus"></span>-</button>&nbsp;
        </td>
        <td></td>
        <br />
    </tr>
    </c:forEach>



        <tr>
        <td colspan="7" align="right"><b>Total: </b></td>
    </tr>
    <tr>
        <td colspan="6" align="right">
            <button form="clearcart" type="submit" class="clearcart btn btn-danger">Clear cart</button>
        </td>
        <td colspan="5" align="right">
            <a class="btn btn-primary buynow" href="${pageContext.request.contextPath}/test/checkout/">Buy now</a>
        </td>
        
    </tr>
    
    <form method="post" action="clearcart" id="clearcart"></form>

</table>
<%@include file="footer.jsp" %>     
