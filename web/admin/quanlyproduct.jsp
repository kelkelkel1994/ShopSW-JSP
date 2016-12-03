<%-- 
    Document   : quanlyproduct
    Created on : Dec 3, 2016, 10:37:25 PM
    Author     : SONPC
--%>

<%@page import="dao.CategoryDAO"%>
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


    <c:set var="root" value="${pageContext.request.contextPath}"/>

    <!-- Bootstrap Core CSS -->
    <link href="${root}/ShopSW/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${root}/ShopSW/admin/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${root}/ShopSW/admin/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${root}/ShopSW/admin/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản Lý sản phẩm</title>
</head>
<body>
    <%
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Product> listProduct = productDAO.getListProduct();
    %>
    <div id="wrapper">

        <jsp:include page="menu.jsp"></jsp:include>
            <div class="col-lg-12">
                <h1 class="page-header">
                    Quản lý sản phẩm
                </h1>
                <ol class="breadcrumb">
                    <li>
                        <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                    </li>
                    <li class="active">
                        <i class="fa fa-table"></i> Danh sách sản phẩm
                    </li>
                </ol>
            </div>
            <div id="page-wrapper">

                <a href="${root}/ShopSW/admin/themproduct.jsp">Thêm sản phẩm mới</a>
            <div class="row">

                <div class="col-lg-12">
                    <table class="table table-bordered table-hover">

                        <tr >
                            <th >STT</th>
                            <th >Mã SP</th>
                            <th >Mã loại</th>
                            <th >Tên sản phẩm</th>
                            <th >Giá</th>
                            <th >Giá khuyến mãi</th>
                            <th >Mô tả ngắn</th>
                            <th >Hình</th>
                            <th >Trạng thái</th>
                            <th>Tùy chọn</th>
                        </tr>

                        <%                            int count = 0;

                            for (Product product : listProduct) {
                                count++;
                                CategoryDAO categoryDAO = new CategoryDAO();
                                Category c = categoryDAO.getCategory(product.getCategoryID());
                        %>

                        <tr >

                            <td >                    <center>
                            <%=count%></center></td>
                        <td ><center><%=product.getProductID()%></center></td>
                        <td><center><%=c.getCategoryName()%></center></td>
                        <td><center><%=product.getProductName()%></center></td>
                        <td><center><%=product.getProductPrite()%></center></td>
                        <td><center><%=product.getProductPromotionPrice()%></center></td>
                        <td><center><%=product.getProductShortDescription()%></center></td>
                        <td><center><%=product.getProductImagesFeature()%></center></td>
                        <td><center><%
                            if (product.getProductSt() == true) {
                            %>
                            <fieldset id="<%=count%>">
                                <label class="radio-inline">
                                    <input type="radio" name="<%=count%>"  checked>Hiện
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="<%=count%>"   >Ẩn
                                </label>
                            </fieldset>
                            <%} else {%>
                            <fieldset id="<%=count%>">
                                <label class="radio-inline">
                                    <input type="radio" name="<%=count%>"  >Hiện
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="<%=count%>"checked >Ẩn
                                </label>
                            </fieldset>
                            <%}%></center></td>
                        <td >
                        <center>
                            <a href="${root}/ShopSW/admin/suacustomer.jsp?command=update&ID_Customer=<%=product.getProductID()%>">Sửa</a>&nbsp;|
                            <a href="${root}/ShopSW/ManagerCustomerServlet?command=delete&ID_Customer=<%=product.getProductID()%>">Xóa</a>
                        </center>
                        </td>
                        </tr>
                        <%}%>

                    </table>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
