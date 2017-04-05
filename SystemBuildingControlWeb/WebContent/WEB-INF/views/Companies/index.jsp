<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<%@ include file="../Shared/head.jsp"%>
</head>
<body>
	<div id="main" class="container">
		<%@ include file="../Shared/menu.jsp"%>
		<%@ include file="../Companies/form.jsp"%>
		<%@ include file="../Companies/table.jsp"%>
		<%@ include file="../Shared/pagination.jsp"%>
	</div>
	<%@ include file="../Shared/footer.jsp"%>
	<script src="<c:url value="/resources/assets/js/site-clients.js" />"></script>
	<script src="<c:url value="/resources/assets/js/pagination.js" />"></script>
	<script src="<c:url value="/resources/assets/js/companies.js" />"></script>
</body>
</html>