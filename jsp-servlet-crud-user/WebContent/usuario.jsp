<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livro</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css">
<style type="text/css">
table {
  overflow: hidden;
  border-collapse: collapse;
  border:solid red;
  border-width    : 1px 2px 1px 1px;
}
table caption {
  background-color:#ffa;  
}
tr:hover {
  background-color: #ffa;
}

td, th {
  position: relative;
  
}

thead{
background-color: green;
color: white;
}
td:hover::after,
th:hover::after {
  content: "";
  position: absolute;
  left: 0;
  top: -5000px;
  height: 10000px;
  width: 100%;
  z-index: -1;
}
</style>
</head>
<body style="background-image: url(http://www.viagemastral.com/site/wp-content/uploads/fundo-site-home.jpg);">

	<table class="un table">
		<thead>
			<tr>
				<th >ID</th>
				<th>NOME</th>
				<th>LOGIN</th>
				<th>MATRICULA</th>
				<th colspan=2>AÇÃO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuarios">
				<tr>
					<td><c:out value="${usuarios.id}" /></td>
					<td><c:out value="${usuarios.nome}" /></td>
					<td><c:out value="${usuarios.login}" /></td>
					<td><c:out value="${usuarios.matricula}" /></td>
					
					
					<td><a
						href='UsuarioController?action=editar&usuarioId=${usuarios.id}'>Editar</a></td>
					<td><a
						href='UsuarioController?action=deletar&usuarioId=${usuarios.id}'>Deletar</a></td>

				</tr>

			</c:forEach>
		</tbody>
	</table>

	<div align="center">
		<a class="btn btn-primary" href="/jsp-servlet-crud-user/UsuarioController?action=insert">Adicionar Usuario</a>
	</div>

</body>
</html>