<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/aps.css">
	
<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
<title>APS | Editar Usuário</title>
</head>
<body>
	<br>
	<h2>&nbsp;Editar Usuário</h2>
	<br>
	<p style="color: red;">${errorString}</p>

	<c:if test="${not empty userEdit}">
		<form method="POST"
			action="${pageContext.request.contextPath}/adminedit">
			<input type="hidden" name="matricula" value="${userEdit.matricula}" />
			<table id="myTable">
				<tr>
					<td>Matricula</td>
					<td style="color: red;">${userEdit.matricula}</td>
				</tr>
				<tr>
					<td>Nome</td>
					<td style="color: red;">${userEdit.nome}</td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input id="myInputEdit" type="text" name="login"
						value="${userEdit.login}" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input id="myInputEdit" type="text" name="senha"
						value="${userEdit.senha}" /></td>
				</tr>
				<tr>
					<td>Tipo de Acesso</td>
					<td><select name="tipoacesso" class="styled-select slate">
							<option>${userEdit.tipoacesso}</option>
							<option value="1">Admin</option>
							<option value="2">Usuario</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="myInputEdit" type="submit" value="Salvar" /> 
						<input type="button" id="myInputEdit"
						class="button_active"
						onclick="location.href='${pageContext.request.contextPath}/admin';"
						value="Cancelar" />
				</tr>
			</table>
		</form>
	</c:if>

	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>