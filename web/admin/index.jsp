<%-- 
    Document   : index
    Created on : Dec 2, 2016, 3:44:46 PM
    Author     : SONPC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.ChartPie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ChartDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">



        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản trị</title>

                      
         <script type="text/javascript">
                       <%
        ChartDAO charDao = new ChartDAO();
        ArrayList<ChartPie> listchar = charDao.getAll();
    %>
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer",
	{
		title:{
			text: "Số lượng sàn phẩm theo loại"
		},
		legend: {
			maxWidth: 350,
			itemWidth: 120
		},
		data: [
		{
			type: "pie",
			showInLegend: true,
			legendText: "{indexLabel}",
			dataPoints: [
				
                                <%for(ChartPie c : listchar) {%>
                                                        {y: <%=c.getValue()%>,indexLabel: "<%=c.getName()%>"},                 
                                                        <%}%>
			
			]
		}
		]
	});
	chart.render();
}
</script>
            <script src = "js/jquery-2.1.1.min.js" type = "text/javascript" ></script>
            <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
            <script src="js/highcharts.js" type="text/javascript"></script>
            <script src="js/excanvas.js" type="text/javascript"></script>
            <script src="js/canvasjs.min.js" type="text/javascript"></script>
    </head>
    <body>

        <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
            <div id="page-wrapper">
                <div id="chartContainer" style="height: 300px; width: 50%;"></div>
                <div id="chartContainer1" style="height: 300px; width: 50%;"></div>

            </div>

        </div>
                
    </body>
</html>
