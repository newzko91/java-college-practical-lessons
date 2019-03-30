<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>APS | Admin Console</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aps.css">
    <script src="${pageContext.request.contextPath}/js/buscaTabela.js"></script>
	<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
</head>
<body onload="makeTableScroll()">
	<br>
	<h3>&nbsp;Console de Administração</h3>
	<br>
	<p style="color: red;">${errorString}</p>
	<br>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Busca por matricula.."  title="Type in a name">
	<br>
	<table id="myTable">
  		<tr>
  			<th>Matricula</th>
    			<th>Nome</th>
    			<th>Login</th>
    			<th>Senha</th>
    			<th>Tipo de Acesso</th>
    			<th>Editar</th>
    			<th>Remover</th>
  		</tr>
		<c:forEach items="${admin}" var="user">
			<tr>
				<td>${user.matricula}</td>
				<td>${user.nome}</td>
             	<td>${user.login}</td>
             	<td>${user.senha}</td>
             	<td>${user.tipoacesso}</td>
             	<td>
                		<a href="adminedit?matricula=${user.matricula}">Editar</a>
             	</td>
             	<td>
                <a href="admindelete?matricula=${user.matricula}">Remover</a>
             	</td>
			</tr>	
		</c:forEach>
</table>
<br>
<input type="button" id="myInputEdit" class="button_active" onclick="location.href='${pageContext.request.contextPath}/admincreate';" value="Criar Usuário" />
<br>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>