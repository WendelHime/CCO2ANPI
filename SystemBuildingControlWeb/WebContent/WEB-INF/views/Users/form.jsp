
<h3 class="page-header text-center">Usuários</h3>
<form id="formUser">
	<input type="hidden" name="userId" id="id" /> 
	<input type="hidden" name="salt" id="salt" />
	<input type="hidden" name="access" id="access" />
	<div class="row">
		<div class="form-group col-md-12">
			<label for="nome">Nome</label> <input type="name"
				class="form-control" name="name" id="name" required maxlength="100"
				placeholder="Nome completo">
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-3">
			<label for="cpf">CPF</label> <input type="cpf" class="form-control"
				name="cpf" id="cpf" maxlength="11"
				placeholder="Insira apenas números">
		</div>
		<div class="form-group col-md-3">
			<label for="username">Username</label> <input type="username"
				class="form-control" name="username" id="username"
				placeholder="Insira seu nome de usuario">
		</div>
		<div class="form-group col-md-3">
			<label for="password">Senha</label> <input type="password"
				class="form-control" name="password" id="password"
				placeholder="Insira sua senha">
		</div>
		<div class="form-group col-md-3">
			<label for="repeatPassword">Re-insira a Senha</label> <input
				type="password" class="form-control"
				id="repeatPassword" placeholder="Insira sua senha">
		</div>

		<div class="form-group col-md-2">
			<label for="type">Tipo</label> <select name="type" id="type">
				<option value="1">Sindico</option>
				<option value="2">Atendente</option>
				<option value="3">Funcionario</option>
			</select>
		</div>
	</div>
	<span id="status"></span>
	<hr />
	<div id="actions" class="row">
		<div class="col-md-12">
			<button id="btnInsertUser" type="button" class="btn btn-primary"
				name="create" value="Criar">Criar</button>
			<button id="btnUpdateUser" type="button" class="btn btn-primary" name="update"
				value="Alterar">Alterar</button>
			<button id="btnDeleteUser" type="button" class="btn btn-primary" name="delete"
				value="Excluir">Excluir</button>
			<button class="btn btn-default" onclick="this.form.reset();return false;">Cancelar</button>
		</div>
	</div>
</form>
