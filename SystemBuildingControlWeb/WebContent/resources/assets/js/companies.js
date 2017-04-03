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
	var objectCompany = $("#formCompany").serializeArray()
    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
	updateCompany(JSON.stringify(objectCompany)).done(function(data) {
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
					html += "<tr id='row-user-"+companies[i].userId+"'>"
					html += "<td><button id='selectCompany-"+companies[i].userId+"' class='btn btn-default'>"+companies[i].userId+"</button></td>"+"<td>" + companies[i].name + "</td>" + "<td>"
							+ companies[i].username + "</td>" + "<td>"
							+ companies[i].cpf + "</td>"+"<td>"+companies[i].type+"</td>";
					html += "</tr>";
				}
				$("#tableCompanies").append(html);
				for (var i = 0; i < companies.length; i++) {
					$("#selectCompany-"+companies[i].userId).on("click", function() {
						$("#status").empty();
						var columns = $("#row-user-"+this.textContent).children();
						var response = getUser(this.textContent).responseJSON;
						var company = response.response;
						$("#id").val(company.companyId);
						$("#salt").val(company.salt);
						$("#name").val(company.name);
						$("#companyname").val(company.companyname);
						$("#cpf").val(company.cpf);
						$("#type").val(company.type);
						$("#password").val(company.password);
						$("#access").val(JSON.stringify(company.access));
						return false;
					});
				}
			});
}
