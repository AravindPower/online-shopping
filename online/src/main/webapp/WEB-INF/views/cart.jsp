<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

<c:if test="${not empty message }">
   <h3 class="text-center">
   
    ${message}
   
   </h3>

</c:if>



 <c:choose>
   <c:when test="${not empty cartLines}">
   <table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<th style="width: 50%">Product</th>
				<th style="width: 10%">Price</th>
				<th style="width: 8%">Quantity</th>
				<th style="width: 22%" class="text-center">Subtotal</th>
				<th style="width: 10%"></th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach items="${cartLines}" var="cartLine">
		 <%-- <c:if test="${cartLine.available == false}">
						<c:set var="availableCount" value="${availableCount - 1}"/>
		</c:if> --%>
		 	
			<tr>
				<td data-th="Product">
					<div class="row">
						<div class="col-sm-2 hidden-xs">
							<img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" 
								class="img-responsive dataTableImg"/>
						</div>
						<div class="col-sm-10">
							<h4 class="nomargin">${cartLine.product.name}
							
							 <c:if test="${cartLine.availble == false }">
							 
							   <strong style="color:red">(Not Available)</strong> 
							 </c:if>
							 
							</h4>
							
							<p>Brand - ${cartLine.product.brand}</p>
							<p>Description - ${cartLine.product.description}</p>
						
						</div>
					</div>
				</td>
				<td data-th="Price">&#8377;${cartLine.buyingprice} </td>
				<td data-th="Quantity">
				<input type="number" id="count_${cartLine.id}" min="1" max="3" class="form-control text-center" value="${ cartLine.productCount}"></td>
				<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.total}</td>
				<td class="actions" data-th="">
					<button type="button" name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm">
						<span class="glyphicon glyphicon-refresh"></span>
					</button>
					<button class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
				</td>
			</tr>
		 
		 </c:forEach>
		 
		</tbody>
		<tfoot>
			<tr class="visible-xs">
				<td class="text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
			</tr>
			<tr>
				<td><a href="#" class="btn btn-warning"><span
						class="gyphicon gyphicon-chevron-left"></span> Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td class="hidden-xs text-center"><strong>Total &#8377; ${userModel.cart.grandTotal}</strong></td>
				<td><a href="#" class="btn btn-success btn-block">Checkout
						<span class="gyphicon gyphicon-chevron-right"></span>
				</a></td>
			</tr>
		</tfoot>
	</table>
   
   </c:when>
   
   <c:otherwise>
   
     <div class="jumbotron">
        <div class="text-center">
        
         <h1> Your Cart is Empty !</h1>
       
       </div>
     
     </div>
   
   </c:otherwise>
  
 
 </c:choose>



	
</div>