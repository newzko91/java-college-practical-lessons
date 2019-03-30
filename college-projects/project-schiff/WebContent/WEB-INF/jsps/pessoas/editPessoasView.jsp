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
<title>APS | Editar Pessoa</title>
<script type="text/javascript">

  $(document).ready(function(){

    var text1 = '${pessoa.tipo_emp}';
    $("#mySelect1").val(text1);

    var text2 = 'Mushroom pie';
    $("#mySelect2 option[text=" + text2 + "]").attr('selected', 'selected');        

  });

  </script> 
</head>
<body>
	<br>
	<h2>&nbsp;Editar Pessoa</h2>
	<br>
	<p style="color: red;">${errorString}</p>

	<c:if test="${not empty pessoa}">
		<form method="POST" action="${pageContext.request.contextPath}/pessoasedit">
			<input type="hidden" name="matricula" value="${pessoa.matricula}" />
			<table id="myTable">
				<tr>
					<td>Matricula</td>
					<td style="color: red;">${pessoa.matricula}</td>
				</tr>
				<tr>
					<td>Nome</td>
					<td><input id="myInputEdit" type="text" name="nome"
						value="${pessoa.nome}" />
				</tr>
				<tr>
					<td>Endereço</td>
					<td><input id="myInputEdit" type="text" name="endereco"
						value="${pessoa.endereco}" /></td>
				</tr>
				<tr>
					<td>Telefone</td>
					<td><input id="myInputEdit" type="text" name="telefone"
						value="${pessoa.telefone}" /></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input id="myInputEdit" type="text" name="email"
						value="${pessoa.email}" /></td>
				</tr>
				<tr>
					<td>RG</td>
					<td><input id="myInputEdit" type="text" name="rg"
						value="${pessoa.rg}" /></td>
				</tr>
				<tr>
					<td>CPF/CNPJ</td>
					<td><input id="myInputEdit" type="text" name="cpf_cnpj"
						value="${pessoa.cpf_cnpj}" /></td>
				</tr>
				<tr>
					<td id="selection">Status</td>
					<td><select name="status" class="styled-select slate">
							<option value="1">Ativo</option>
							<option value="2">Inativo</option>
							<option value="3">Desligado</option>
							<option value="4">Ferias</option>
							<option value="5">Licenca</option>
					</select></td>
				</tr>
				<tr>
					<td>Personalidade Juridica</td>
					<td><select name="tipo" class="styled-select slate">
					<!--  		<option>${pessoa.tipo}</option> -->
							<option value="1">PF</option>
							<option value="2">PJ</option>
					</select></td>
				</tr>
				<tr>
					<td>Tipo Base RH</td>
					<td><select name="tipo_emp" class="styled-select slate">
						<!-- 	<option>${pessoa.tipo_emp}</option> -->
							<option value="1">Cliente</option>
							<option value="2">Funcionario</option>
					</select></td>
				</tr>
				<tr>
					<td>Departamento</td>
					<td><select name="depto" id="mySelect1">
							<option value='${pessoa.depto}'>${pessoa.depto}</option>
							<option value="1">Controle de Cargas</option>
							<option value="2">RH</option>
							<option value="3">Seg da Informação</option>
							<option value="4">Cliente</option>

					</select></td>
				</tr>
				<tr>
					<td>Cargo</td>
					<td><select name="cargo" class="styled-select slate">
					<!-- 		<option>${pessoa.cargo}</option> -->
							<option value="1">Operador</option>
							<option value="2">Cliente</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input id="myInputEdit" type="submit"
						value="Salvar" /> <input type="button" id="myInputEdit"
						class="button_active"
						onclick="location.href='${pageContext.request.contextPath}/pessoas';"
						value="Cancelar" />
				</tr>
			</table>
		</form>
	</c:if>

	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>