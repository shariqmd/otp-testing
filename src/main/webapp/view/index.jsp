<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 
    <title>Hello, world!</title>
    
    <style>
.container-fluid{
background-color: #898d91;
}

    </style>
  </head>
  <body>
  
  <div class="container-fluid">

  	
  			<jsp:include page="../common/header.jsp"></jsp:include>

  	
  	
  
  </div>
   <!-- end of navbar -->
   
   
   
	  
   

   		<div class="container">
   			<h2 class="text-center">Otp testing</h2>
   			
   			<hr/>
   			<!-- otp sending form -->
   			
   			<div class="row" id="otpsending" >
   			<div class="col-md-6 m-auto">
   	
   			<input type="number" class="form-control " placeholder="Enter mobile no" id="mobile"> 
   			<hr/>
   			<button class="btn btn-primary" id="otpbtn">Send otp</button>			    	
   			</div>
			
   			</div>
   			
   			
   			
   			<!--otp verifying  form  -->
   				<div class="row" id="otpverifying" style="display:none">
   			<div class="col-6 m-auto">
   	
   			<input type="number" class="form-control " placeholder="Enter otp" id="otp">
   			<hr/>
   			<button class="btn btn-primary" id="otpverify">verify otp</button>					    	
   			</div>
			
   			</div>
   		
   		</div>
   		
 

   
   
   
   		
  	 
   <script>
   
   $(document).ready(function(){ 
	   
	 
	  $("#otpbtn").click(function(){
		  
		  var mobile=$("#mobile").val();
		  
		  if(mobile=="")
			  {
			  
			  alert("plz enter mobile no !")
			  return false;
			  }
		$.ajax({
			
			url:'http://localhost:8080/sentotp',
			data:{inputs:mobile},
			success:function(data)
			{
				$("#otpsending").hide();
				$("#otpverifying").show();
				
			},
			error:function()
			{
				
				alert("you did some wrong thank you")
			}
			
			
		});
		
		 
	  });
	  
	  
	  $("#otpverify").click(()=>{
		 	
		 var otp=$("#otp").val();
		 
		 if(otp=="")
			 {
			 alert("enter otp plx")
			 return false;
			 }
		 
		 $.ajax({
			url:'http://localhost:8080/verify',
			data:{otp1:otp},
			success:function(data)
			{
				alert("message"+data)
			},
			error:function()
			{
				alert("you have done some mistake")
			}
			 
			 
			 
		 });
		  
	  });
   });
   
   </script>
  

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

   
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>