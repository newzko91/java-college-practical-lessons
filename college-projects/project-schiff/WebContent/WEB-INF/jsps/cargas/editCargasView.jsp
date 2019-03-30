<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12">
				<div class="content-box-blue border-right-top">
					<h4>
						Editar Carga <span class="pull-right"> <a href="${pageContext.request.contextPath}/cargas"
							class="btn-link">
								<i class="fa fa-chevron-left"></i> Ir para Lista
						</a>
						</span>
					</h4>
				</div>
			</div>
		</div>

		<form name="" class="form-horizontal" role="form" method="POST"
			action="${pageContext.request.contextPath}/cargasedit">
			<div class="content-box-blue">

				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label">Id <span
						class="error-required"></span></label>
					<div class="col-sm-6">
						<input name="id" type="text" value="${c.id}" class="form-control"
							disabled="disabled">
					</div>
				</div>

				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label">Descrição <span
						class="error-required">*</span></label>
					<div class="col-sm-6">
						<input name="descricao" type="text" class="form-control"
							value="${c.descricao}" required>
					</div>
				</div>

				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label">Matricula do
						Responsável <span class="error-required">*</span>
					</label>
					<div class="col-sm-6">
						<input name="responsavel" type="text" class="form-control"
							value="${c.responsavel_matricula}" required>
					</div>
				</div>


				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label">Número Registro Navio<span
						class="error-required">*</span></label>
					<div class="col-sm-6">
						<input name="transportador" type="text" class="form-control"
							value="${c.transportador}" required>
					</div>
				</div>

				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label">Tipo da Carga <span
						class="error-required">*</span></label>
					<div class="col-sm-6">
						<input name="tipo" type="text" class="form-control"
							value="${c.tipo_carga}" required>
					</div>
				</div>

				<div class="form-group col-sm-12">
					<label for="" class="col-sm-2 control-label">Tempo Estimado
						de Transporte (dias) <span class="error-required">*</span>
					</label>
					<div class="col-sm-6">
						<input name="number" type="text" class="form-control"
							value="${c.tempotransporte}"
							required>
					</div>
				</div>

				<br>
			</div>

			<div class="content-box card text-center">
				<div class="content-box letter-space ng-scope">
					<p class="span-light">
						Campos com <span class="error-required">*</span> são obrigatórios.
					</p>

					<div class="div-btn-tooltip ng-scope"
						tooltip="Campos com (*) são obrigatórios!">
						<input class="btn btn-success" type="submit" value="Salvar" />
					</div>
					ou <a href="${pageContext.request.contextPath}/cargas">Cancelar</a>
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>