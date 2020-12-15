<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">
	
<c:if test="${not empty message}">	
		<div class="col-xs-12">			
			<div class="alert alert-success alert-dismissible">			
				<button type="button" class="close" data-dismiss="alert">&times;</button>	
				${message}		
			</div>
		</div>
</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group" >
							<label class="control-label col-md-4">Brand</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Brand Name" /> 
								<sf:errors path="brand" cssClass="help-block" element="em"/>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" /> 
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" class="form-control"
									placeholder="Enter Quantity" />
								<sf:errors path="quantity" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<!-- File Element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						
						


						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId"
								 items="${categories}" 
								 itemLabel="name" 
								 itemValue="id" 
								 class="form-control"/>
								 
								 <c:if test="${product.id==0}">
								  <div class="text-right">
								   <br/>
								    <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning">Add Category</button>
							 
								 </div>
								 </c:if>
							
								<div class="text-right">
									<br/>			
									<sf:hidden path="id"/>
									<sf:hidden path="code"/>
									<sf:hidden path="supplierId"/>
									<sf:hidden path="active"/>														
								</div>							
							</div>
							
						</div>


					
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-4">
							
								<input type="submit" name="submit" value="Save" class="btn btn-primary"/>
								
							</div>
						</div>						
										
					</sf:form>

				</div>

			</div>

		</div>

	</div>



<div class="row">

<div class="col-xs-12">
	<h3>Available Products</h3>
	<hr/>
</div>

 <div class="col-xs-12">
 <div class="container-fluid">
  <div class="table-responsive">
  
  
 
  <!-- products table for admin -->
  <table id="adminProdutsTable" class="table table-striped table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
		
  
  </div>
 
 </div>
 </div>
 
 </div>


</div>
  
  <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
  
    <div class="modal-dialog" role="document">
     <div class="modal-content">
          <!-- Modal Header -->
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">
        		<span>&times;</span> 
         </button>
         <h4 class="modal-title">Add New Category</h4>
       </div>
       <div class="modal-body">
         <!-- Category form -->
       	<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
       	
       	 <div class="form-group">
       	  <label for="category_name" class="control-label col-md-4">Category Name</label>
       	   <div class="col-md-8">
       	     <sf:input type="text" path="name" id="category_name" class="form-control"/>
       	   
       	   </div>
       	 
       	 </div>
       	 
       	 <div class="form-group">
       	  <label for="category_description" class="control-label col-md-4">Category Description</label>
       	   <div class="col-md-8">
       	     <sf:textarea type="text" path="description" id="category_description" class="form-control"/>
       	   
       	   </div>
       	 
       	 </div>
       	 
       	 <div class="form-group">
       	   <div class="col-md-offset-4 col-md-8">
       	   
       	      <input type="submit" value="Add Category" class="btn btn-primary"/>
       	   
       	   </div>
       	 
       	 
       	 </div>
       		
       		
       	
       	
       	</sf:form>
       
       </div>
     
     </div>
    
    
    </div>
  
  
  </div>
  

