/**
 * File used to actions related to the user pages
 */

/**
 * Method used when button is clicked to insert user
 */
$("#btnInsertUser").click(function() {
	insertUser($("#formUser").serialize()).done(function(data) {
		if(data.statusCode == 201) {
			$("#status").text("Usuario inserido!");
			updateTable();
		} else {
			$("#status").text("Falha ao inserir usuario, tente novamente mais tarde");
		}
	});
	return false;
});

$("#btnUpdateUser").click(function() {
	var objectUser = $("#formUser").serializeArray()
    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
	objectUser.access = JSON.parse(objectUser.access);
	updateUser(JSON.stringify(objectUser)).done(function(data) {
		if(data.statusCode == 202) {
			$("#status").text("Usuario alterado!");
			updateTable();
		} else {
			$("#status").text("Falha ao atualizar usuario, tente novamente mais tarde");
		}
	});
	return false;
});

$("#btnDeleteUser").click(function() {
	var objectUser = $("#formUser").serializeArray()
    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
	objectUser.access = JSON.parse(objectUser.access);
	deleteUser(JSON.stringify(objectUser)).done(function(data) {
		if(data.statusCode == 204) {
			$("#status").text("Usuario deletado!");
			updateTable();
		} else {
			$("#status").text("Falha ao deletar usuario, tente novamente mais tarde");
		}
	});
	return false;
});

$(updateTable());

function updateTable() {
	var response = getUsers(pageSize, offset).done(
			function(data) {
				$("#tableUsers").empty();
				var users = data.response;
				total = data.total;
				var html = "";
				for (var i = 0; i < users.length; i++) {
					html += "<tr id='row-user-"+users[i].userId+"'>"
					html += "<td><button id='selectUser-"+users[i].userId+"' class='btn btn-default'>"+users[i].userId+"</button></td>"+"<td>" + users[i].name + "</td>" + "<td>"
							+ users[i].username + "</td>" + "<td>"
							+ users[i].cpf + "</td>"+"<td>"+users[i].type+"</td>";
					html += "</tr>";
				}
				$("#tableUsers").append(html);
				for (var i = 0; i < users.length; i++) {
					$("#selectUser-"+users[i].userId).on("click", function() {
						$("#status").empty();
						var columns = $("#row-user-"+this.textContent).children();
						var response = getUser(this.textContent).responseJSON;
						var user = response.response;
						$("#id").val(user.userId);
						$("#salt").val(user.salt);
						$("#name").val(user.name);
						$("#username").val(user.username);
						$("#cpf").val(user.cpf);
						$("#type").val(user.type);
						$("#password").val(user.password);
						$("#access").val(JSON.stringify(user.access));
						return false;
					});
				}
			});
}
