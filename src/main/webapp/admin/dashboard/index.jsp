<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:admin_tamplate title="Dashboard">

	<jsp:attribute name="content">
	
	<section class="content">
			
	  <section class="content-header">
	    
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li>
		    <h3>Home</h3></li>
		  </ol>
		</nav> 
				
		<div class="row">

	        <div class="col-md-3 col-sm-6 col-xs-12">
	          <div class="info-box">
	            <span class="info-box-icon bg-aqua"><i class="ion ion-ios-people-outline"></i></span>
	            <div class="info-box-content" align="center">
	              <span class="info-box-text">Contatos</span>
	              <span class="info-box-number">${numContato}</span>
	            </div>
	          </div>
	        </div>


	        <div class="col-md-3 col-sm-6 col-xs-12">
	          <div class="info-box">
	            <span class="info-box-icon bg-red"><i class="ion ion-ios-people-outline"></i></span>
	            <div class="info-box-content">
	              <span class="info-box-text">Médicos</span>
	              <span class="info-box-number">0</span>
	            </div>
	          </div>
	        </div>
	

	        <div class="clearfix visible-sm-block"></div>
	
	        <div class="col-md-3 col-sm-6 col-xs-12">
	          <div class="info-box">
	            <span class="info-box-icon bg-green"><i class="ion ion-ios-people-outline"></i></span>
	
	            <div class="info-box-content">
	              <span class="info-box-text">Agedamentos</span>
	              <span class="info-box-number">0</span>
	            </div>
	          </div>
	        </div>
	        <div class="col-md-3 col-sm-6 col-xs-12">
	          <div class="info-box">
	            <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>
	
	            <div class="info-box-content">
	              <span class="info-box-text">Pacientes</span>
	              <span class="info-box-number">0</span>
	            </div>
	          </div>
	        </div>
	      </div>
				 
	      </section>
     </section>

</jsp:attribute>

</mt:admin_tamplate>