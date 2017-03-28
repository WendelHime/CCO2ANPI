<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Controle Predial</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<!--ALTERAR O CAMINHO(APONTAR PARA O PROJETO)-->
<link href="css/style.css" rel="stylesheet">
<!--ALTERAR O CAMINHO(APONTAR PARA O PROJETO)-->
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="users.html">Usu�rios</a> <a
					class="navbar-brand" href="employer.html">Empresas</a>
			</div>
		</div>
	</nav>
	<div id="main" class="container">
		<h3 class="page-header text-center">Usu�rios</h3>
		<form id="formUser">
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="name"
						class="form-control" name="name" id="name" required
						maxlength="100" placeholder="Nome completo">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="cpf">CPF</label> <input type="cpf" class="form-control"
						name="cpf" id="cpf" maxlength="11"
						placeholder="Insira apenas números">
				</div>
				<div class="form-group col-md-3">
					<label for="username">Nome</label> <input type="username"
						class="form-control" name="username" id="username"
						placeholder="Insira seu nome de usuário">
				</div>
				<div class="form-group col-md-3">
					<label for="password">Senha</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Insira sua senha">
				</div>
				<div class="form-group col-md-3">
					<label for="password">Re-insira a Senha</label> <input
						type="password" class="form-control" name="password" id="password"
						placeholder="Insira sua senha">
				</div>

				<div class="form-group col-md-2">
					<label for="type">Tipo</label> <select name="type">
						<option value="1">Sindico</option>
						<option value="2">Atendente</option>
						<option value="3">Funcionario</option>
					</select>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="create"
						value="Criar">Criar</button>
					<button type="submit" class="btn btn-primary" name="update"
						value="Alterar">Alterar</button>
					<button type="submit" class="btn btn-primary" name="consult"
						value="Consultar">Consultar</button>
					<button type="submit" class="btn btn-primary" name="delete"
						value="Excluir">Excluir</button>
					<a href="index.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<!--ALTERAR O CAMINHO(APONTAR PARA O PROJETO)-->
	<script src="js/bootstrap.min.js"></script>
	<!--ALTERAR O CAMINHO(APONTAR PARA O PROJETO)-->
</body>

</html>