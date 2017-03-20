<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="utf-8" />
</head>
<body>
	<form id="userForm" action="<c:url value="/User/insert.htm" />"
		method="post">
		<label>Username: </label><input type="text" name="username" /><br />
		<label>Password: </label><input type="password" name="password" /><br />
		<label>Name: </label><input type="text" name="name" /><br /> 
		<label>CPF: </label><input type="text" name="cpf" /><br />
		<label>Type: </label> 
		<select name="type">
			<option value="1">Syndic</option>
			<option value="2">Clerk</option>
			<option value="3">Employee</option>
		</select>
		<input type="submit" value="Inserir" />
	</form>
</body>
</html>