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
	<div class="col-sm-6">
		<div class="panel panel-primary painel-cadastro">
			<div align="center" class="panel-heading"><span style="color: white;">Adicionar Livro</span></div>
			<div class="panel-body">

				<form method="post" action="LivroController" name="frmAddLivro">
					<div class="row">

						<!--$(mensagem)-->

						<fieldset>


							<div class="form-group">
								<label>User ID :</label>
								<input type="text" readonly="readonly" class="form-control" id="nome" name="livroCodigo" value="${livro.codigo}"/>
							</div>

							<div class="form-group">
								<label>Título :</label>
								<input type="text" class="form-control" id="titulo" name="titulo" value="${livro.titulo}"/>
							</div>


							<div class="form-group">
								<label>Autor :</label>
								<input type="text" class="form-control" id="autor" name="autor" value="${livro.autor}"/>
							</div>

							<div class="form-group">
								<label>Descrição :</label>
								<input type="text" class="form-control" id="descricao" name="descricao" value="${livro.descricao}"/>
							</div>
							
							<div class="form-group">
								<label>Imagem :</label>
								<input type="text" class="form-control" id="imagem" name="imagem" value="${livro.imagem}"/>
							</div>
							
							<div class="form-group">
								<label>Preço :</label>
								<input type="text" class="form-control" id="preco" name="preco" value="${livro.preco}"/>
							</div>

						</fieldset>

						<div>
							<input type="submit" class="btn btn-primary" value="Adicionar"/>
							<a class="btn btn-primary" href="LivroController?action=listarLivros">Listar Livros</a>
							<a class="btn btn-primary" href='LivroController?action=deletar&livroId=<c:out value="${livro.titulo}"/>'>Buscar Livro</a>
						</div>



					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>