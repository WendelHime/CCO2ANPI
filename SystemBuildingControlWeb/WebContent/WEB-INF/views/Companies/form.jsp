<h3 class="page-header text-center">Empresas</h3>

<form id="formCompany">
	<input type="hidden" name="id" id="id" />
	<input type="hidden" name="employers" id="employers" />
	<input type="hidden" name="set" id="set" />
	<div class="row">
		<div class="form-group col-md-12">
			<label for="socialReason">Razão Social</label> <input
				class="form-control" id="socialReason" name="socialReason"
				placeholder="Razão social" type="text" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-3">
			<label for="cnpj">CNPJ</label> <input class="form-control" id="cnpj"
				name="cnpj" placeholder="Insira apenas números" type="text" />
		</div>

		<div class="form-group col-md-5">
			<label for="businessHours">Horário de funcionamento da
				empresa</label> <input class="form-control" id="businessHours"
				name="businessHours" placeholder="Insira o horário de funcionamento"
				type="text" />
		</div>

		<div class="form-group col-md-12">
			<h4>Ar-Condicionado</h4>
		</div>

		<div class="form-group col-md-5">
			<label for="maximumTemperature">Temperatura maxima</label> <input
				class="form-control" id="maximumTemperature"
				name="maximumTemperature" placeholder="Insira a temperatura maxima"
				type="number" min="16" step="0.01" />
		</div>

		<div class="form-group col-md-5">
			<label for="airconditionerHours">Horario de funcionamento do
				ar-condicionado</label> <input class="form-control" id="airconditionerHours"
				name="airconditionerHours"
				placeholder="Insira o horário de funcionamento do ar-condicionado"
				type="text" />
		</div>
	</div>

	<hr />
	<div class="row" id="actions">
		<div class="col-md-12">
			<button class="btn btn-primary" name="create" type="submit"
				value="Criar" id="btnInsertCompany">Criar</button>
			<button class="btn btn-primary" name="update" type="submit"
				value="Alterar" id="btnUpdateCompany">Alterar</button>
			<!--Verificar método (read ou consult)-->
			<button class="btn btn-primary" name="delete" type="submit"
				value="Excluir" id="btnDeleteCompany">Excluir</button>
			<button class="btn btn-default" onclick="this.form.reset();">Cancelar</button>
		</div>
	</div>
</form>