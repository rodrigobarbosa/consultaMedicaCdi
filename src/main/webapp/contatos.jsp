<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contatos</title>
</head>
<body>
	<div align="center" style="margin-top: 300px;">
		<h1>Contatos Cadastrados</h1>
		<br>

		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
				</tr>
				<c:forEach items="${contatos}" var="contato">
					<tr>
						<td><c:out value="${contato.id}"></c:out></td>
						<td><c:out value="${contato.nome}"></c:out></td>
						<td><c:out value="${contato.email}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>