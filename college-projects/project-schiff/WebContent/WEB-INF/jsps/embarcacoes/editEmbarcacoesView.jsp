<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/forms.css">
<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
</head>
<body>
	<br>
		<p style="color: red;">${errorString}</p>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12">
				<div class="content-box-blue border-right-top">
					<h4>
						Editar Embarcação <span class="pull-right"> <a href="${pageContext.request.contextPath}/embarcacoes"
							class="btn-link"> <i class="fa fa-chevron-left"></i> Ir para
								Lista
						</a>
						</span>
					</h4>
				</div>
			</div>
		</div>

		<c:if test="${not empty embarcacaoEdit}">
			<form name="" class="form-horizontal" method="POST"
				action="${pageContext.request.contextPath}/embarcacaoedit">
				<div class="content-box-blue">

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">Id <span
							class="error-required"></span></label>
						<div class="col-sm-6">
							<input type="hidden" name="matricula" value="${emb.id}" />
							<td style="color:red">${emb.id}</td>
						</div>
					</div>

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">Descrição <span
							class="error-required">*</span></label>
						<div class="col-sm-6">
							<input name="descricao" type="text" class="form-control"
								value="${emb.descricao}"=>
						</div>
					</div>

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">Fabricante <span
							class="error-required">*</span></label>
						<div class="col-sm-6">
							<input name="fabricante" type="text" class="form-control"
								vaue="${emb.fabricante}" required>
						</div>
					</div>

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">Ano de Fabricação <span
							class="error-required">*</span></label>
						<div class="col-sm-6">
							<input name="ano_fab" type="text" class="form-control"
								value="${emb.ano_fab}" required>
						</div>
					</div>

					<div class="form-group col-sm-12">
						<label class="col-sm-2 control-label">Tamanho <span
							class="error-required">*</span></label>
						<div class="col-sm-6">
							<select name="tamanho" class="form-control">
								<option>Escolha o tamanho</option>
								<option value="1">Muito Pequeno</option>
								<option value="2">Pequeno</option>
								<option value="3">Médio</option>
								<option value="4">Grande</option>
								<option value="5">Muito Grande</option>
							</select>
						</div>
					</div>

					<br>
				</div>

				<div class="content-box card text-center">
					<div class="content-box letter-space ng-scope">
						<p class="span-light">
							Campos com <span class="error-required">*</span> são
							obrigatórios.
						</p>

						<div class="div-btn-tooltip ng-scope"
							tooltip="Campos com (*) são obrigatórios!">
							<input class="btn btn-success" type="submit" value="Salvar" />
						</div>
						ou <a href="${pageContext.request.contextPath}/embarcacoes">Cancelar</a>
					</div>
				</div>

			</form>
		</c:if>
	</div>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>