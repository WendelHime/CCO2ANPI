/**
 * File used to actions related to the company pages
 */

/**
 * Method used when button is clicked to insert user
 */
$("#btnInsertCompany").click(function() {
	insertCompany($("#formCompany").serialize()).done(function(data) {
		if(data.statusCode == 201) {
			$("#status").text("Empresa inserida!");
			updateTable();
		} else {
			$("#status").text("Falha ao inserir empresa, tente novamente mais tarde");
		}
	});
	return false;
});

$("#btnUpdateCompany").click(function() {
	var object = $("#formCompany").serializeArray()
    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
	object.employers = JSON.parse(object.employers);
	object.sets = JSON.parse(object.sets);
	updateCompany(JSON.stringify(object)).done(function(data) {
		if(data.statusCode == 202) {
			$("#status").text("empresa alterada!");
			updateTable();
		} else {
			$("#status").text("Falha ao atualizar empresa, tente novamente mais tarde");
		}
	});
	return false;
});

$("#btnDeleteCompany").click(function() {
	var object = $("#formCompany").serializeArray()
    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
	object.employers = JSON.parse(object.employers);
	object.sets = JSON.parse(object.sets);
	deleteCompany(JSON.stringify(object)).done(function(data) {
		if(data.statusCode == 204) {
			$("#status").text("empresa deletado!");
			updateTable();
		} else {
			$("#status").text("Falha ao deletar empresa, tente novamente mais tarde");
		}
	});
	return false;
});

$(updateTable());

function updateTable() {
	var response = getCompanies(pageSize, offset).done(
			function(data) {
				$("#tableCompanies").empty();
				var companies = data.response;
				total = data.total;
				var html = "";
				for (var i = 0; i < companies.length; i++) {
					html += "<tr id='row-company-"+companies[i].userId+"'>"
					html += "<td><button id='selectCompany-"+companies[i].id+"' class='btn btn-default'>"+companies[i].id+"</button></td>"
					+ "<td>" + companies[i].socialReason + "</td>" 
					+ "<td>" + companies[i].cnpj + "</td>" 
					+ "<td>" + companies[i].businessHours + "</td>";
					html += "</tr>";
				}
				$("#tableCompanies").append(html);
				for (var i = 0; i < companies.length; i++) {
					$("#selectCompany-"+companies[i].userId).on("click", function() {
						$("#status").empty();
						var columns = $("#row-company-"+this.textContent).children();
						var response = getUser(this.textContent).responseJSON;
						var company = response.response;
						$("#id").val(company.id);
						$("#socialReason").val(company.socialReason);
						$("#cnpj").val(company.cnpj);
						$("#businessHours").val(company.businessHours);
						$("#maximumTemperature").val(company.maximumTemperature);
						$("#airconditionerHours").val(company.airconditionerHours);
						$("#employers").val(JSON.stringify(company.employers));
						$("#set").val(JSON.stringify(company.set));
						return false;
					});
				}
			});
}
