<%-- 
    Document   : demo
    Created on : Dec 13, 2016, 7:31:11 PM
    Author     : SONPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <form action="./BuscarRecetaServlet" method="POST">     
    <table border="1">
        <tr>
            <th><FONT FACE="Times New Roman" SIZE=3> NombreReceta </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> CantidadIngredientes </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> Ingredientes </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> ModoPreparacion </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> Calorias </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> Tiempo </th>
            <th><FONT FACE= "Times New Roman" SIZE=3> Dificultad </th>
        </tr>
  <c:forEach items="${AllReceipes}" var="receipt">        
    <tr>
        <td><c:out value="${receipt.nombreReceta}"/></td>
        <td><c:out value="${receipt.cantidadIngredientes}"/></td>
        <td><c:out value="${receipt.ingredientes}"/></td>
        <td><c:out value="${receipt.modoPreparacion}"/></td>
        <td><c:out value="${receipt.calorias}"/></td>
        <td><c:out value="${receipt.tiempo}"/></td>
        <td><c:out value="${receipt.dificultad}"/></td>
    </tr>
</c:forEach>
</table>
    </form>
</body>
</html>
