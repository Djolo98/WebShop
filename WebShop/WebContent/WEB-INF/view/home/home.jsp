<%@include file="header.jsp" %>
<div class="row products">
<c:forEach items="${products}" var="tempProduct" varStatus="counter">

            <div class="col-xs-12 col-md-4 p">
                <img src="${tempProduct.image}" width="244" height="244">
                <h3>${tempProduct.title}</h3>
                <h4><b>Price:</b> <b>$${tempProduct.price}</b></h4>
                <p><b>Availability: ${tempProduct.availability}</b></p>
          		<p><b>Category: ${category.name}</b></p>
          		<a href="${pageContext.request.contextPath}/home/tobasket/${tempProduct.id}"><img src="${pageContext.request.contextPath}/resources/images/shopping-cart.png"/></a>
            </div>
</c:forEach>

<%@include file="footer.jsp" %>                         
                





