<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<%@ include file="../Shared/head.jsp"%>
</head>
<body>
	<div id="main" class="container">
		<%@ include file="../Shared/menu.jsp"%>
		<%@ include file="../Users/loginForm.jsp"%>
	</div>
	<%@ include file="../Shared/footer.jsp"%>

	<script>
		function authentication(serializedForm) {
			return $.ajax({
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				url : "/SystemBuildingControlWeb/User/authUser",
				data : serializedForm,
				cache : false
			});
		}
		$("#btnAuthUser").click(function() {
			authentication(JSON.stringify($("#formLogin").serializeArray()
				    .reduce(function(a, x) { a[x.name] = x.value; return a; }, {}))).done(function(data) {
				if (data.statusCode == 200) {
					$("#status").text("Login realizado com sucesso!");
				} else {
					$("#status").text("Usuario ou senha invalido!");
				}
			})
			.fail(function(jqXHR, textStatus, error) {
				alert("Error: "+error + "\njqXHR: "+jqXHR+"\ntextStatus: "+textStatus);
			});
			return false;
		});
	</script>
</body>
</html>