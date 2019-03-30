<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
	<h3 color="red">Erro ao excluir embarcação!</h3>
	<br>
	<a href="${pageContext.request.contextPath}/embarcacoes">Voltar</a>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>