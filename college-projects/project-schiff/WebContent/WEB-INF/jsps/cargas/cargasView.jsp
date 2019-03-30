<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>APS | Lista de Cargas</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/aps.css">
<script src="${pageContext.request.contextPath}/js/buscaTabela.js"></script>
<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
</head>
<body>

	<div class="container">
		<br>
		<h3>&nbsp;Lista de Cargas</h3>
		<br>
		<p style="color: red;">${errorString}</p>
		<br> <input type="text" class="form-control" id="myInput"
			onkeyup="myFunction()" placeholder="Busca por..."> <br>
		<table id="myTable">
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Matricula do Responsável</th>
				<th>Nome do Responsável</th>
				<th>Número Registro Navio</th>
				<th>Nome do Navio Transportador</th>
				<th>Tipo da Carga</th>
				<th>Tempo Estimado de Transporte (dias)</th>
				<th>Editar</th>
				<th>Remover</th>
			</tr>
			<c:forEach items="${cargasView}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.descricao}</td>
					<td>${c.responsavel_matricula}</td>
					<td>${c.responsavel_nome}</td>
					<td>${c.transportador}</td>
					<td>${c.transportador_nome}</td>
					<td>${c.tipo_carga}</td>
					<td>${c.tempotransporte}</td>
					<td><a href="cargasedit?id=${c.id}">Editar</a>
					</td>
					<td><a href="cargasdelete?id=${c.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
<input type="button" id="myInputEdit" class="button_active" onclick="location.href='${pageContext.request.contextPath}/cargascreate';" value="Cadastrar Carga" />
<br>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>