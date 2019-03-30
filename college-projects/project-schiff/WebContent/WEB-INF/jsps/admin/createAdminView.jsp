<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css">
</head>
<body>

<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
	
	<div class="container">
	<div class="row">
	  <div class="col-lg-12 col-sm-12">
		<div class="content-box-blue border-right-top">
		  <h4>
			Novo Usuário
			<span class="pull-right">
			  <a class="btn-link"> <i class="fa fa-chevron-left"></i> Ir para Lista </a>
			</span>
		  </h4>
		</div>
	  </div>
	</div>

	<form method="POST" action="${pageContext.request.contextPath}/admincreate">
	
		<div class="content-box-blue">
			<div class="form-group col-sm-12">
			  <label class="col-sm-2 control-label">Matrícula <span class="error-required">*</span></label>
			  <div class="col-sm-6">
				<input name="matricula" type="text" value="${user.matricula}" class="form-control" placeholder="Digite a matrícula">
			  </div>
			</div>
			
			<div class="form-group col-sm-12">
			  <label class="col-sm-2 control-label">Login <span class="error-required">*</span></label>
			  <div class="col-sm-6">
				<input name="login" value="${user.login}" type="text" class="form-control" placeholder="Digite o login" required>
			  </div>
			</div>
			
			<div class="form-group col-sm-12">
			  <label class="col-sm-2 control-label">Senha <span class="error-required">*</span></label>
			  <div class="col-sm-6">
				<input name="senha" value="${user.senha}" type="text" class="form-control" placeholder="Digite a senha" required>
			  </div>
			</div>
			
			<div class="form-group col-sm-12 btn-line">
		        <label class="col-sm-2 control-label">Tipo de Acesso</label>
		        <div class="col-sm-6 mini-grid proj-input">
		            <div class="col-lg-10">
		              <select name="tipoacesso" class="form-control ng-pristine ng-valid">
		                    <option disabled>Selecione o Tipo</option>
		                    <option value="1">Admin</option>
							<option value="2">Usuario</option>
		              </select>
		            </div>
		        </div>
	      	</div>
      	</div>
	      	
	      	<div class="content-box card text-center">
	      		<div class="content-box letter-space ng-scope">
	        		<p class="span-light"> Campos com <span class="error-required">*</span> são obrigatórios.</p>
	
	        		<div class="div-btn-tooltip ng-scope" tooltip="Campos com (*) são obrigatórios!">
	          			<button class="btn btn-success" type="submit">Salvar</button>
	        		</div>
	        		ou <a onclick="location.href='${pageContext.request.contextPath}/admin';">Cancelar</a>
	   			</div>
	    	</div>
	</form>
<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>