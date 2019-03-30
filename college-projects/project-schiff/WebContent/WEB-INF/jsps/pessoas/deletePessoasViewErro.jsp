<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<br>
	<h3 color="red">Erro ao excluir pessoa!</h3>
	<br>
	<input type="button" id="myInputEdit" class="button_active"
		onclick="location.href='${pageContext.request.contextPath}/pessoas';"
		value="Voltar" />

	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>