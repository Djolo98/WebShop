<%@include file="header.jsp" %>
<div class="leftbox">
          <h3>${product.title}</h3>
          <img src="${product.image}" width="244" height="244">
          <p><b>Price:</b> <b>$${product.price}</b></p>
          <p><b>Category: </b></p> 
          <div class="clear"></div>
          <form method="post" action="addtobasket">
		    <input type="hidden" name="id" value="${product.id}">
		    <input type="number" min="1" max="${product.availability}" name="quantity" value="1">
		    <input type="submit" value="Add to Basket">
		 </form>
        </div>
<%@include file="footer.jsp" %>  
