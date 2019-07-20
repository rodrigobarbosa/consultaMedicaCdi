<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.acme.business.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.acme.model.*" %>
<%@page import="br.com.acme.dao.*" %>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Dashboard">
	
	
	<jsp:attribute name="content">
	
		<section class="content">
		
		
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Usuários</li>
		  </ol>
		</nav>
		
		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Novo Usuário</h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            
            <form role="form" method="POST">
            
              <div class="box-body">
              
              	<div class="form-group">
					<input type="hidden" name="id" value="${usuario.id}" />
				</div>
				
				<div class="form-group">
					<input type="hidden" name="ativo" value="${usuario.ativo}" />
				</div>
              
                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="nome" name="nome" class="form-control" required="required" value="${usuario.nome}" id="nome" placeholder="Informe o nome">
                </div>
                
                 <div class="form-group">
                  <label for="login">Login</label>
                  <input type="login" name="login" class="form-control" required="required" value="${usuario.login}" id="login" placeholder="Informe o login">
                </div>
                
                <div class="form-group">
                  <label for="email">Email</label> 
                  <input type="email" name="email" class="form-control" required="required" value="${usuario.email}" id="email" placeholder="Informe o email">
                </div>
                
                <div class="form-group">
                  <label for="telefone">Telefone</label>
                  <input type="telefone" name="telefone" class="form-control" required="required" value="${usuario.telefones}" id="telefone" placeholder="Informe o email">
                </div>
                
                <div class="form-group">
					<label for="senha">Senha</label> 
					<input type="password"  value="${usuario.senha}" name="senha" required="required" class="form-control" id="senha" placeholder="Digite a senha">
				</div>
				
				<c:if test="${usuario.id != null}">
						
						<div class="form-group col-md-2">
						
							<label for="admin">Administrador</label>
							
								<c:if test="${usuario.administrador}"> 
									<input  type="checkbox"  checked="checked" value="Administrador"  name="permissoes" /> 
								</c:if>
								
								<c:if test="${!usuario.administrador}"> 
									<input  type="checkbox"  value="Administrador"  name="permissoes" /> 
								</c:if>
						
						</div>
						
						<div class="form-group col-md-2">
						
							<label for="visita">Visitante</label> 
							
								<c:if test="${usuario.visitante}">
									<input  type="checkbox" checked="checked" value="Visitante" name="permissoes" />
								</c:if>
								
								<c:if test="${!usuario.visitante}">
									<input  type="checkbox" value="Visitante" name="permissoes" />
								</c:if>
						</div>
				</c:if>
				
				
				<c:if test="${usuario.id == null}">
				
					<div class="form-group col-md-2">
						<label for="admin">Administrador</label> 
						<input  type="checkbox" value="Administrador"  name="permissoes" >
					</div>
					
					<div class="form-group col-md-2">
						<label for="visita">Visitante</label> 
						<input  type="checkbox"  value="Visitante" name="permissoes" >
					</div>
				</c:if>
								
              </div>
				<div class="box-footer">
					<c:if test="${usuario.id != null}">
						<button type="submit" class="btn btn-sm btn-warning">Editar</button>&nbsp;&nbsp;&nbsp;&nbsp;
	            	</c:if>
					
					<c:if test="${usuario.id == null}">
						<button name="enviar" type="submit" class="btn btn-sm btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					
					<a href="${pageContext.request.contextPath}/admin/usuarios?action=list" class="btn btn-sm btn-default">Usuários</a>&nbsp;&nbsp;&nbsp;&nbsp;
						
				</div>
              
					
            </form>
      	</div>
			
	 </section>
  
	</jsp:attribute>
</mt:admin_tamplate>
