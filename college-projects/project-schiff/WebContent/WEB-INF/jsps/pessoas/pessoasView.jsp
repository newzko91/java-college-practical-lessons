<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>APS | Pessoas</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aps.css">
    <script src="${pageContext.request.contextPath}/js/buscaTabela.js"></script>
    <jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
</head>
<body onload="makeTableScroll()">
	<br>
	<h3>&nbsp;Pessoas</h3>
	<br>
	<p style="color: red;">${errorString}</p>
	<br>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Busca por matricula.."  title="Type in a name">
	<br>
	<div style="overflow: auto; width: 1279px" id="myTable">
	<table>
  		<tr>
  			<th>Matricula</th>
    			<th>Nome</th>
    			<th>Endereco</th>
    			<th>Telefone</th>
    			<th>E-mail</th>
    			<th>RG</th>
    			<th>CPF/CNPJ</th>
    			<th>Status</th>
    			<th>Personalidade Juridica</th>
    			<th>Base RH</th>
    			<th>Departamento</th>
    			<th>Cargo</th>
    			<th>Editar</th>
    			<th>Remover</th>
  		</tr>
		<c:forEach items="${pessoaView}" var="p">
			<tr>
				<td>${p.matricula}</td>
				<td>${p.nome}</td>
             	<td>${p.endereco}</td>
             	<td>${p.telefone}</td>
             	<td>${p.email}</td>
             	<td>${p.rg}</td>
             	<td>${p.cpf_cnpj}</td>
             	<td>${p.status}</td>
             	<td>${p.tipo}</td>
             	<td>${p.tipo_emp}</td>
             	<td>${p.depto}</td>
             	<td>${p.cargo}</td>
             	<td>
                		<a href="pessoasedit?matricula=${p.matricula}">Editar</a>
             	</td>
             	<td>
                <a href="pessoasdelete?matricula=${p.matricula}">Remover</a>
             	</td>
			</tr>	
		</c:forEach>
</table>
</div>
<br>
<input type="button" id="myInputEdit" class="button_active" onclick="location.href='${pageContext.request.contextPath}/pessoascreate';" value="Inserir Pessoa" />
<br>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>