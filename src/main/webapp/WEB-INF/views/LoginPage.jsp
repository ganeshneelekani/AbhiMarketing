<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <jsp:include page="pageHeader.jsp"/>
   </head>
   <body>
      <script type="text/javascript" src="bootstrap/js/jquery.validation.js"></script> 
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
                     <li><a class="nav-link-dropdown nav-item" href="/AbhiMarketing/AddProduct">AddProduct</a></li>
                  </ul>
               </li>
            </ul>
         </div>
      </nav>
      <div class="container">
         </br>
         </br>
         </br>
         <div class="row">
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
               <div class="card card-container">
                  <form:form id="loginForm" modelAttribute="LoginPage" action="/AbhiMarketing/loginUser" method="post" class="form-signin" >
                     <c:if test="${not empty errorMessage}">
                        <div class="row">
                           <div class="col-xs-12 col-sm-12 col-md-12">
                              <div class="alert alert-danger col-xs-12 col-sm-12 col-md-12">
                                 <c:out value="${errorMessage}"/>
                              </div>
                           </div>
                        </div>
                     </c:if>
                     <c:if test="${not empty successMessage}">
                        <div class="row">
                           <div class="col-xs-12 col-sm-12 col-md-12">
                              <div class="alert alert-success col-xs-12 col-sm-12 col-md-12">
                                 <c:out value="${successMessage}"/>
                              </div>
                           </div>
                        </div>
                     </c:if>
                     <table align="center">
                        <tr>
                           <td>
                              <form:input path="userName" name="userName" id="userName" placeholder="Username" class="form-control"  />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <form:password path="password" name="password" id="password" placeholder="Password" class="form-control"  />
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" id="submit" >Sign in</form:button>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <a href="#" class="forgot-password">
                              Forgot the password?
                              </a>
                           <td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/AbhiMarketing/AddProduct">AddProduct</a>
                           <td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/AbhiMarketing/AddConsignee">AddConsignee</a>
                           <td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/AbhiMarketing/listOfProduct">List Product</a>
                           <td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/AbhiMarketing/listOfConsignee">List of Consignee</a>
                           <td>
                        </tr>
                        <tr>
                           <td>
                              <a href="/AbhiMarketing/addUser">Add User</a>
                           <td>
                        </tr>
                        <tr></tr>
                     </table>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>
