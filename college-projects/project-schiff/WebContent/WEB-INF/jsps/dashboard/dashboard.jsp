<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Parte importante 1 -->

<script src="${pageContext.request.contextPath}/js/script.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/aps.css">
<jsp:include page="../../jsps/includes/_header.jsp"></jsp:include>
<script type="text/javascript">

window.onload = function () {
	
	// Gráfico 1
	var chartOne = new CanvasJS.Chart("chartContainerOne", {
        height: 260,
        width: 320,
		title:{
			text: "Tipos De Carga"              
		},
		data: [              
		{
			type: "column",
			dataPoints: [
				{ label: "Tipo 1",  y: 10  },
				{ label: "Tipo 2", y: 15  },
				{ label: "Tipo 3", y: 25  },
				{ label: "Tipo 4",  y: 30  },
				{ label: "Tipo 5",  y: 28  }
			]
		}
		]
    });
    
    // Gráfico 2
    var chartTwo = new CanvasJS.Chart("chartContainerTwo", {
        height: 260,
        width: 320,
		title:{
			text: "Poluição (Por Carga)"              
		},
		data: [              
		{
			type: "doughnut",
			dataPoints: [
				{ label: "Tipo 1",  y: 10  },
				{ label: "Tipo 2", y: 15  },
				{ label: "Tipo 3", y: 25  },
				{ label: "Tipo 4",  y: 30  },
				{ label: "Tipo 5",  y: 28  }
			]
		}
		]
    });

    // Gráfico 3
    var chartThree = new CanvasJS.Chart("chartContainerThree", {
	animationEnabled: true,
	title:{
		text: "Gasto Trimestral Com Combustível De Acordo Com Navio/Carga"
	},
	axisX: {
		valueFormatString: "DD MMM,YY"
	},
	axisY: {
		title: "Litros",
		includeZero: false,
		suffix: " L"
	},
	legend:{
		cursor: "pointer",
		fontSize: 16,
		itemclick: toggleDataSeries
	},
	toolTip:{
		shared: true
	},
	data: [{
		name: "Tipo de Navio/Carga 1",
		type: "spline",
		yValueFormatString: "#0.## L",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,2,31), y: 31 },
			{ x: new Date(2017,5,31), y: 31 },
			{ x: new Date(2017,8,31), y: 29 },
			{ x: new Date(2017,11,31), y: 29 },
		]
	},
	{
		name: "Tipo de Navio/Carga 2",
		type: "spline",
		yValueFormatString: "#0.## L",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,2,31), y: 20 },
			{ x: new Date(2017,5,31), y: 20 },
			{ x: new Date(2017,8,31), y: 25 },
			{ x: new Date(2017,11,31), y: 25 },
		]
    },
    {
		name: "Tipo de Navio/Carga 3",
		type: "spline",
		yValueFormatString: "#0.## L",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,2,31), y: 22 },
			{ x: new Date(2017,5,31), y: 26 },
			{ x: new Date(2017,8,31), y: 21 },
			{ x: new Date(2017,11,31), y: 28 },
		]
	},
	{
		name: "Tipo de Navio/Carga 4",
		type: "spline",
		yValueFormatString: "#0.## L",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,2,31), y: 22 },
			{ x: new Date(2017,5,31), y: 19 },
			{ x: new Date(2017,8,31), y: 23 },
			{ x: new Date(2017,11,31), y: 24 },
		]
	}]
    });
    
    chartOne.render();
    chartTwo.render();
    chartThree.render();

    function toggleDataSeries(e){
	    if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	} else {
	    e.dataSeries.visible = true;
	}
	chartThree.render();
    }
    
}
</script>
<!-- Fim da parte importante 1 -->

</head>
<body>

	<!-- Parte importante 2 -->

	<div style="display: flex; justify-content: center; margin-top: 10px">
		<div id="chartContainerOne" style="height: 300px; width: 25%;"></div>

		<div id="chartContainerTwo" style="height: 300px; width: 25%;"></div>
	</div>

	<div id="chartContainerThree" style="height: 300px; width: 100%;"></div>

	<!-- Fim  da parte importante 2 -->
	<br>
	<jsp:include page="../../jsps/includes/_footer.jsp"></jsp:include>
</body>
</html>