<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<%@ include file="../Shared/head.jsp"%>
</head>
<body>
	<div id="main" class="container">
		<%@ include file="../Shared/menu.jsp"%>
		<%@ include file="../Users/form.jsp"%>
		<%@ include file="../Users/table.jsp"%>
	</div>
	<%@ include file="../Shared/footer.jsp"%>
	<script src="<c:url value="/resources/assets/js/site-clients.js" />"></script>
	<script src="<c:url value="/resources/assets/js/users.js" />"></script>
</body>
</html>