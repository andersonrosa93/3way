<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Livro</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css">
</head>
<body style="background-image: url(http://www.viagemastral.com/site/wp-content/uploads/fundo-site-home.jpg);">
	<div class="container clearfix" class="col-sm-6">
		<div class="panel panel-primary painel-cadastro">
			<div align="center" class="panel-heading"><span style="color: white;">Adicionar usuario</span></div>
			<div class="panel-body">

				<form method="post" action="UsuarioController" name="frmAddUsuario">
					<div class="row">

						<!--$(mensagem)-->

						<fieldset>


							<div class="form-group">
								<label>User ID :</label>
								<input type="text" readonly="readonly" class="form-control" id="id" name="id" value="${usuario.id}"/>
							</div>

							<div class="form-group">
								<label>Nome :</label>
								<input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}"/>
							</div>


							<div class="form-group">
								<label>Login :</label>
								<input type="text" class="form-control" id="login" name="login" value="${usuario.login}"/>
							</div>

							<div class="form-group">
								<label>Matricula :</label>
								<input type="text" class="form-control" id="matricula" name="matricula" value="${usuario.matricula}"/>
							</div>
							

						</fieldset>

						<div align="center">
							<input type="submit" class="btn btn-primary" value="Adicionar"/>
							<a class="btn btn-primary" href="UsuarioController?action=listarUsuarios">Listar usuarios</a>
						</div>



					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>