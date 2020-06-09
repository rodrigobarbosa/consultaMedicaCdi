<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.consultemed.controller.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.consultemed.model.*" %>
<%@page import="br.com.consultemed.dao.*" %>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Dashboard">
	
	
	<jsp:attribute name="content">
	
		<section class="content">
		
		
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Pacientes</li>
		  </ol>
		</nav>
		 
		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Novo Paciente</h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            
            <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/pacientes?action=list">
              <div class="box-body">
             
                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="nome" name="nome" class="form-control" value="${paciente.nome}" id="nome" placeholder="Informe o nome">
                </div>
                
                <div class="form-group">
                  <label for="cpf">CPF</label>
                  <input type="cpf" name="cpf" class="form-control" value="${paciente.cpf}" id="email" placeholder="Informe o cpf">
                </div>
                
                <div class="form-group">
                  <label for="identificacao">Identificação</label>
                  <input type="identificacao" name="identificacao" class="form-control" value="${paciente.identificacao}" id="telefone" placeholder="Informe a identificação">
                </div>
                
              </div>

              <div class="box-footer">
					<c:if test="${paciente.cpf != null}">
						<button type="submit" class="btn btn-warning">Editar</button>
	            	</c:if>
					
					<c:if test="${paciente.cpf == null}">
						<button name="enviar" type="submit" class="btn btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<a href="${pageContext.request.contextPath}/admin/pacientes?action=list" class="btn btn-sm btn-default">Pacientes</a>&nbsp;&nbsp;&nbsp;&nbsp;
              </div>
            </form>
      	</div>
			
	 </section>
  
	</jsp:attribute>
</mt:admin_tamplate>
