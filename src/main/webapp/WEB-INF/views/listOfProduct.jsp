<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login Information</title>
      <script
         type="text/javascript" src="bootstrap/js/common/jquery.min.js"></script>
      <script type="text/javascript" src="bootstrap/js/common/jquery.validate.min.js"></script>
      <!-- Website CSS style -->
      <!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
      <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
      <link href="bootstrap/css/jquery.validation.css" rel="stylesheet">
      <!-- Google Fonts -->
      <link href='bootstrap/js/common/PassionOne.css'
         rel='stylesheet' type='text/css'>
      <link href='bootstrap/js/common/Oxygen.css'
         rel='stylesheet' type='text/css'>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
         integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
         crossorigin="anonymous"></script>
      <script type="text/javascript" src="bootstrap/js/productValidation.js"></script> 
      <script type="text/javascript" src="bootstrap/js/datePicker.js"></script> 
   </head>
   <body>
      <script type='text/javascript'>
         $(function() {
         	//calendar call function
         	$('.datepicker').dcalendar();
         	$('.datepicker').dcalendarpicker();

         	    var max_fields = 10; //maximum input boxes allowed
         	    var x = 1; //initlal text box count

         	$('#add').click(function () {
         		if(x < max_fields){ //max input box allowed
         		    x++; //text box increment
         		    $("#addblock").before('<div class="col-md-12 col-sm-12" id="deceased">	<a href="#" class="remove_field" title="Remove">X</a>	<div class="form-group col-md-3 col-sm-3">            <label for="name">Name*</label>            <input type="text" class="form-control input-sm" id="name" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="gender">Gender*</label>            <input type="text" class="form-control input-sm" id="gender" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="age">Age*</label>            <input type="text" class="form-control input-sm" id="age" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOB">Date of Birth or Exact Birth Year*</label>            <input type="text" class="form-control input-sm datepicker" id="DOB'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOD">Date of Death or Exact Death Year*</label>             <input type="text" class="form-control input-sm datepicker" id="DOD'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="mother">Deceased Person\'s Mother Name*</label>            <input type="text" class="form-control input-sm" id="mother" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="father">Deceased Person\'s Father Name*</label>            <input type="text" class="form-control input-sm" id="father" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">	    <label for="photo">Upload Photo*</label>	    <input type="file" id="photo">	    <p class="help-block">Please upload individual photo. Group photo is not acceptable.</p>	</div></div>');

         			$('.datepicker').dcalendarpicker();
         		}  else{
         			alert("Only 10 Names Allowed");
         		}
         	});
         	$(document).on('click', '.remove_field', function(e){
         	        e.preventDefault();
         		$(this).parent('div').remove();
         		x--;
         	});
         });
      </script>
      <nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-primary">
         <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
         </button>
         <a class="navbar-brand" href="#">BS 4 <strong>My Resume</strong></a>
         <div class="collapse navbar-collapse" id="navbarResponsive" name="navbarResponsive">
            <ul class="navbar-nav mr-auto">
               <li class="nav-item">
                  <a class="nav-link active" href="#resume">Resume <span class="sr-only">(current)</span></a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#attributes">Attributes</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#certifications">Certifications</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#skills">Skills</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="#schools">Education</a>
               </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
               <li class="dropdown">
                  <a href="#" class="dropdown-toggle nav-link nav-item"
                     data-toggle="dropdown" role="button" aria-haspopup="true"
                     aria-expanded="false">ABOUT US</a>
                  <ul class="dropdown-menu">
                     <li><a class="nav-link-dropdown nav-item" href="#">Action</a></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Another action</a></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Something </a></li>
                     <li role="separator" class="divider"></li>
                     <li><a class="nav-link-dropdown nav-item" href="#">Separated link</a></li>
                  </ul>
               </li>
            </ul>
         </div>
      </nav>
      </br>
      </br>
      <div class="container">
         <div class="row">
            <c:forEach var="listValue" items="${listOfProduct}">
               <div class="col-md-4 col-xs-4 col-sm-4 col-md-4">
                  <div class="product-item">
                     <!--
                        <div class="pi-img-wrapper">
                           <img  src="<c:url value="/resources/images/defaultProduct.png"/>" alt="TestDisplay"/>
                           <div>
                              <a href="#" class="btn">View</a>
                           </div>
                        </div> -->
                     <h3>
                        <label class="control-label-product-name">
                           <c:out value="${listValue.productName}" />
                        </label>
                        </br> </br>
                        <label class="control-label-name"> Product Id  - </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.productId}" />
                        </label>
                        </br>
                        <label class="control-label-name"> HSN Code  - </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.hsnCode}" />
                        </label>
                        </br>
                        <label class="control-label-name"> GST - </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.gstPercentage} %" />
                        </label>
                        </br>
                        <label class="control-label-name"> Weight/Jar in Gms-  </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.weightPerJar}" />
                        </label>
                        </br>
                        <label class="control-label-name">Pieces/Jar  - </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.noOfPiecesPerJar}" />
                        </label>
                        </br>
                        <label class="control-label-name"> Jars/Cartoon  -  </label>
                        <label class="control-label-product">
                           <c:out value="${listValue.noOfJarsPerCartoon}" />
                        </label>
                        </br>
                        <label class="control-label-name"> Base Price in Rs -  </label>
                        <label class="control-label-product-baseprice">
                           <c:out value="${listValue.basicPrice} " />
                        </label>
                        </br>
                     </h3>
                     <div>

                     <!-- <a href="javascript:;" class="btn add2cart"> <c:out value="Rs ${listValue.basicPrice}" /></a>-->
                     <a href="${listValue.productId}" class="btn btn-primary btn-sm" style="float:left">
                     <span><strong> Edit </strong></span>
                     </a>
                     <a href="${listValue.productId}" class="btn btn-primary btn-sm " style="float:right">
                                          <span><strong>Delete</strong></span>
                                          </a>
                                          </div>
                  </div>
               </div>
            </c:forEach>
         </div>
      </div>
   </body>
</html>
