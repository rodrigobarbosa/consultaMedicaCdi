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
		
		<caption>
           	<h4>
           		<c:if test="${cadastro != null}">
           			<div class="alert alert-success" role="alert">
					  ${cadastro}
					</div>
           		</c:if>
           	</h4>
           	
           	<h4>
           		<c:if test="${editado != null}">
           			<div class="alert alert-success" role="alert">
					  ${editado}
					</div>
           		</c:if>
           	</h4>
           	
           	<h4>
           		<c:if test="${remover != null}">
           			<div class="alert alert-danger" role="alert">
					  ${remover}
					</div>
           		</c:if>
           	</h4>
         </caption>
		
		
		 <div class="box box-info">
		 
            <div class="box-header with-border">
              <h3 class="box-title">Lista Usuários</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="table-responsive">
              	
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Status</th>
                    <th>Permissões</th>
                    <th>Ações</th>
                  </tr>
                  </thead>
					<c:forEach var="u" items="${usuarios}">
						<tr>
							<td>${u.nome == null ? '' : u.nome}</td>
							<td>${u.login == null ? '' : u.login}</td>
							<td>${u.ativo ? 'Ativo' : 'Inativo'}</td>
							<td>${u.administrador ? 'Administrador' : ''}  ${u.visitante ? 'Visitante' : ''}</td>
							<td>
                        		<a href="${pageContext.request.contextPath}/admin/usuarios?id=${u.id}&action=editar" class="btn btn-sm btn-primary">Editar</a>&nbsp;&nbsp;&nbsp;
                        		
                        		<a onclick="setaDadosModal(${u.id});" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#exampleModal">Excluir</a>
                        		 
								<a href="${pageContext.request.contextPath}/admin/usuarios?id=${u.id}&action=ativar_desativar" 
                        				class="${u.ativo ? "btn btn-sm btn-warning" : "btn btn-sm btn-success" }">${u.ativo ? 'Desativar' : 'Ativar'}</a>
							</td>
						</tr>
				
				</c:forEach>
                </table>
              </div>
            </div>
            <div class="box-footer clearfix">
				<a href="${pageContext.request.contextPath}/admin/usuarios?action=novo" class="btn btn-sm btn-primary">Novo</a>&nbsp;&nbsp;&nbsp;&nbsp;
				
            </div>
          </div>
          
          
        <!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Excluir Usuário</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <strong>Deseja excluir o usuário selecionado ?</strong>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		        <a id="removerUsuario" class="btn btn-danger">Deletar</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<script type="text/javascript">
		
		function setaDadosModal(valor) {
			var remove = '${pageContext.request.contextPath}/admin/usuarios?id='+valor+'&action=delete';
		    document.getElementById('removerUsuario').href = remove;
		}
	
	
	
	</script>
		
		
	</section>
  
	</jsp:attribute>
</mt:admin_tamplate>
