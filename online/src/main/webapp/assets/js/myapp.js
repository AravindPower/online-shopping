$(function() {
	//Active menu problem
	switch (menu) {

	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		break; 

	}

	//code for jquery dataTable


	var $table = $('#productListTable');

	//execute the below code only where we have this table

	if ($table.length) {
		
		 var jsonUrl = '';
		 if(window.categoryId == ''){
			 jsonUrl = window.contextRoot + '/json/data/all/products';
		 }else
			 jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';

		
		
		$table.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Rec', '5 Rec', '10 Rec', 'All' ] ],
			pageLength : 5,
			
			ajax: {
				url : jsonUrl,
				dataSrc : ''
			},
			
			columns : [
				{
					data:'code',
					mRender : function(data,type,row){
						return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				
				{
					data : 'name'
				},
				
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender:function(data,type,row){
						return '&#8377; '+data
					}
				},
				
				{
					data : 'quantity',
					mRender:function(data,type,row){
						if(data < 1){
							return '<span style="color:red">Out of Stock !</span>';
						}
						return data;
					}
				},
				
				{
				data: 'id',
				bSortable:false,
				mRender :function(data,type,row){
					var str = '';
					str += '<a href="'+window.contextRoot+'/show/'+data+'/product/" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
					
					if(row.quantity < 1){
						
						str += '<a href="javascript:void(0)" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}else{
						str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product/" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}
					
					
					return str;
				}
				
					
					
				}
				
				
				
				
			]
			
			
			
		});
	}
	
	//dismissing alert after 3 seconds
	
	$alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
	    	$alert.fadeOut('slow');
		   }, 3000
		);		
	}
	
	
	//---------------------------------
	
	
		$('.switch input[type="checkbox"]').on('change' , function() {							
			var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
			var checked = this.checked;
			var checkbox = $(this);
			debugger;
		    bootbox.confirm({
		    	size: 'medium',
		    	title: 'Product Activation/Deactivation',
		    	message: dText,
		    	callback: function (confirmed) {
			        if (confirmed) {
			            $.ajax({							            	
			            	type: 'GET',
			            	url: window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation',
			        		timeout : 100000,
			        		success : function(data) {
			        			bootbox.alert(data);							        										        			
			        		},
			        		error : function(e) {
			        			bootbox.alert('ERROR: '+ e);
			        			//display(e);
			        		}						            	
			            });
			        }
			        else {							        	
			        	checkbox.prop('checked', !checked);
			        }
		    	}
		    });																											
		});
			
	//----------------------------------------
    //data table for admin
		

		var $adminProdutsTable = $('#adminProdutsTable');

		//execute the below code only where we have this table

		if ($adminProdutsTable.length) {
			
			 var jsonUrl = window.contextRoot +'/json/data/admin/all/products';
			
			
			
			$adminProdutsTable.DataTable({
				lengthMenu : [
						[ 10, 30, 50, -1 ],
						[ '10 Rec', '30 Rec', '50 Rec', 'All' ] ],
				pageLength : 30,
				
				ajax: {
					url : jsonUrl,
					dataSrc : ''
				},
				
				columns : [
					 {
						 data: 'id'
					 },
					
					
					{
						data:'code',
						mRender : function(data,type,row){
							return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
						}
					},
					
					{
						data : 'name'
					},
					
					{
						data : 'brand'
					},
				
					
					{
						data : 'quantity',
						mRender:function(data,type,row){
							if(data < 1){
								return '<span style="color:red">Out of Stock !</span>';
							}
							return data;
						}
					},
					
					{
						data : 'unitPrice',
						mRender:function(data,type,row){
							return '&#8377; '+data
						}
					},
					
					{
					data: 'active',
					bSortable: false,
					mRender:function(data,type,row){
						var str= '';
						str += '<label class="switch">';
					  	 if(data){
					  		 str+= '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
					  	 } else{
					  		 str+= '<input type="checkbox"  value="'+row.id+'"/>';
					  	 }
				  	   
				  	    str+= '<div class="slider"></div></label>';
				  	  
				  	  return str;
				  	
						
					}
					
				},
				
				{
					data: 'id',
					bSortable:false,
					mRender:function(data,type,row){
						var str = '';
						str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">'
				  	     +'<span class="glyphicon glyphicon-pencil "></span></a>';
				  	    
				  	    return str;
					}
				}
					
					
					
					
				],
				//switch toggle load
				initComplete:function(){
					var api=this.api();
				 api.$('.switch input[type="checkbox"]').on('change' , function() {							
						var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
						var checked = this.checked;
						var checkbox = $(this);
						debugger;
					    bootbox.confirm({
					    	size: 'medium',
					    	title: 'Product Activation/Deactivation',
					    	message: dText,
					    	callback: function (confirmed) {
						        if (confirmed) {
						            $.ajax({							            	
						            	type: 'GET',
						            	url: window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation',
						        		timeout : 100000,
						        		success : function(data) {
						        			bootbox.alert(data);							        										        			
						        		},
						        		error : function(e) {
						        			bootbox.alert('ERROR: '+ e);
						        			//display(e);
						        		}						            	
						            });
						        }
						        else {							        	
						        	checkbox.prop('checked', !checked);
						        }
					    	}
					    });																											
					});
						
					
				}
				//-----------------
				
				
			});
		}
		
    //-----------------------------------
   // 	validation code for category
		
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			
			rules:{
				name:{
					required:true,
					minlength:2
				},
				description:{
					required : true
				}
			},
			
			messages :{
				name : {
					required : 'Please Enter Product name !',
					minlength : 'The category Length should not be less than 2 char'
				},
				description :{
					required : 'please add description for category !'
				}
			},
			errorElement : 'em',
			errorPlacement: function(error,element){
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
			
		});
	}
		
//---------------------------------------
	

});