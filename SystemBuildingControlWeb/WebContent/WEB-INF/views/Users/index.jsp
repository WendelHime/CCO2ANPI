<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<%@ include file="../Shared/head.jsp"%>
</head>
<body>
	<%@ include file="../Shared/menu.jsp"%>
	<%
	    String filepath = (String) request.getAttribute("data");
	%>
	<c:import url=filepath></c:import>
	<%@ include file="../Shared/footer.jsp"%>
</body>
</html>