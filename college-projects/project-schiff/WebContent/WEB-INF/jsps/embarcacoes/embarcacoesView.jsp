<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/aps.css">
<script src="${pageContext.request.contextPath}/js/buscaTabela.js"></script>

</head>
<body>
	<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
	<div class="container">
		<br>
		<h3>&nbsp;Lista de Embarcações</h3>
		<br>
		<p style="color: red;">${errorString}</p>
		<br> <input type="text" class="form-control" id="myInput"
			onkeyup="myFunction()" placeholder="Busca por..."> <br>
		<table id="myTable">
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Fabricante</th>
				<th>Ano de Fabricação</th>
				<th>Matricula do Responsável</th>
				<th>Nome do Responsável</th>
				<th>Porte</th>
				<th>Tamanho</th>
				<th>Nivel Gasto de Combustivel</th>
				<th>Editar</th>
				<th>Remover</th>
			</tr>
			<c:forEach items="${embarcacaoView}" var="emb">
				<tr>
					<td>${emb.id}</td>
					<td>${emb.descricao}</td>
					<td>${emb.fabricante}</td>
					<td>${emb.ano_fab}</td>
					<td>${emb.responsavel}</td>
					<td>${emb.responsavel_nome}</td>
					<td>${emb.porte}</td>
					<td>${emb.tamanho}</td>
					<td>${emb.nivelgasto_combustivel}</td>
					<td><a href="embarcacaoedit?id=${emb.id}">Editar</a>
					</td>
					<td><a href="embarcacaodelete?id=${emb.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
<input type="button" id="myInputEdit" class="button_active" onclick="location.href='${pageContext.request.contextPath}/embarcacoescreate';" value="Cadastrar Embarcacao" />
<br>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>