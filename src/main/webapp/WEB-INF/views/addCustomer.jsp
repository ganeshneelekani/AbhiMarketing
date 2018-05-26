<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <jsp:include page="pageHeader.jsp" />
      <script type="text/javascript" src="bootstrap/js/customerValidation.js"></script>
   </head>
   <body>
      <script type='text/javascript'>
         $(function() {
             //calendar call function
             $('.datepicker').dcalendar();
             $('.datepicker').dcalendarpicker();

             var max_fields = 10; //maximum input boxes allowed
             var x = 1; //initlal text box count

             $('#add').click(function() {
                 if (x < max_fields) { //max input box allowed
                     x++; //text box increment
                     $("#addblock").before('<div class="col-md-12 col-sm-12" id="deceased">	<a href="#" class="remove_field" title="Remove">X</a>	<div class="form-group col-md-3 col-sm-3">            <label for="name">Name*</label>            <input type="text" class="form-control input-sm" id="name" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="gender">Gender*</label>            <input type="text" class="form-control input-sm" id="gender" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="age">Age*</label>            <input type="text" class="form-control input-sm" id="age" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOB">Date of Birth or Exact Birth Year*</label>            <input type="text" class="form-control input-sm datepicker" id="DOB' + x + '" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOD">Date of Death or Exact Death Year*</label>             <input type="text" class="form-control input-sm datepicker" id="DOD' + x + '" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="mother">Deceased Person\'s Mother Name*</label>            <input type="text" class="form-control input-sm" id="mother" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="father">Deceased Person\'s Father Name*</label>            <input type="text" class="form-control input-sm" id="father" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">	    <label for="photo">Upload Photo*</label>	    <input type="file" id="photo">	    <p class="help-block">Please upload individual photo. Group photo is not acceptable.</p>	</div></div>');

                     $('.datepicker').dcalendarpicker();
                 } else {
                     alert("Only 10 Names Allowed");
                 }
             });
             $(document).on('click', '.remove_field', function(e) {
                 e.preventDefault();
                 $(this).parent('div').remove();
                 x--;
             });
         });
      </script>
      <nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-primary">
         <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
         </button>
         <a class="navbar-brand" href="#">BS 4 <strong>My Resume</strong></a>
         <div class="collapse navbar-collapse" id="navbarResponsive" name="navbarResponsive">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                                <a class="nav-link active" href="/AbhiMarketing">Home</a>
                           </li>
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
                  <a href="#" class="dropdown-toggle nav-link nav-item" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ABOUT US</a>
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
      <div class="container">
         </br>
         </br>
         <div class="card card-container-register col-xs-12 col-sm-6 col-md-6 col-lg-6 col-sm-offset-2 col-md-offset-4"
         <div>
            <div class="panel panel-default">
               <div class="panel-body">
                  <form:form id="addcustomer" modelAttribute="customer" action="/AbhiMarketing/registerCustomer" method="post" class="form-signin">
                     <c:if test="${not empty errorMessage}">
                        <div class="row">
                           <div class="col-xs-12 col-sm-12 col-md-12">
                              <div class="alert alert-danger col-xs-12 col-sm-12 col-md-12 ">
                                 <c:out value="${errorMessage}" />
                                 </strong>
                              </div>
                           </div>
                        </div>
                     </c:if>
                     <c:if test="${not empty sucessMessage}">
                        <div class="row">
                           <div class="col-xs-12 col-sm-12 col-md-12">
                              <div class="alert alert-success col-xs-12 col-sm-12 col-md-12">
                                 <c:out value="${sucessMessage}" />
                              </div>
                           </div>
                        </div>
                     </c:if>
                     <div class="form-group">
                        <form:input type="text" path="customerName" name="customerName" id="customerName" class="form-control" placeholder="Customer Name" />
                     </div>
                     <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                           <div class="form-group">
                              <form:input type="text" path="mobileNumber" name="mobileNumber" id="mobileNumber" class="form-control" placeholder="Contact Number" />
                           </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                           <div class="form-group">
                              <form:input type="text" path="customerEmailAddress" name="customerEmailAddress" id="customerEmailAddress" class="form-control" placeholder="Email Address" />
                           </div>
                        </div>
                     </div>
                     <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                           <div class="form-group">
                              <form:password path="password" name="password" id="password" class="form-control" placeholder="Password" />
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <form:textarea type="text" path="address" name="address" id="address" class="form-control" placeholder="Address" />
                     </div>
               </div>
               <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="submit"> Submit </form:button>
            </div>
            </form:form>
         </div>
      </div>
      </div>
      </div>
   </body>
</html>