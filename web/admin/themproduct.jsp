<%-- 
    Document   : themproduct
    Created on : Dec 4, 2016, 3:30:12 PM
    Author     : SONPC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:set var="root" value="${pageContext.request.contextPath}"/>


        <!-- Bootstrap Core CSS -->
        <link href="${root}/admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${root}/admin/css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="${root}/admin/ss/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${root}/admin/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Sản phẩm mới</title>


    </head>
    <body>
        <%
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> listLoai = categoryDAO.getListLoai();
        %>
        <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Thêm sản phẩm
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> Thêm sản phẩm mới
                        </li>
                    </ol>
                </div>
                <div id="page-wrapper">
                    <div class="row">
                        <form action="/ShopSW/ManagerProductServlet" method="post" enctype="multipart/form-data">
                            <div class="panel panel-success" >
                                <div class="panel-heading">
                                    <h3 class="panel-title"> Điền thông tin sản phẩm</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>Tên sản phẩm</label>
                                            <input type="text" class="form-control" name="tenSanpham" placeholder="Nhập tên Sản phẩm" required>
                                        </div>



                                        <div class="form-group">
                                            <label>Chọn Loại</label>
                                            <select class="form-control" name="maLoai">
                                            <%
                                                for (Category category : listLoai) {
                                            %>
                                            <option value="<%=category.getCategoryID()%>"><%=category.getCategoryName()%></option>
                                            <%}%>

                                        </select>
                                    </div>

                                    <div class="form-group input-group">
                                        <span class="input-group-addon">$</span>
                                        <input type="number" class="form-control" name="gia" placeholder="Giá bán" required>
                                        <span class="input-group-addon">VNĐ</span>
                                    </div>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon">$</span>
                                        <input type="number" class="form-control" name="giaKM" placeholder="Giá khuyến mãi" >
                                        <span class="input-group-addon">VNĐ</span>
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả ngắn</label>
                                        <input class="form-control" name="motaNgan" placeholder="Mô tả ngắn">
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả</label>
                                        <textarea class="form-control" name="mota" rows="3"></textarea>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>Hình đại diện</label>
                                         <input type="file" class="form-control" name="uploadFile"  >
                                    </div>
                                    <div class="form-group">
                                        <label>Sub1</label>
                                         <input type="file" class="form-control" name="hinh2" >
                                    </div>
                                    <div class="form-group">
                                        <label>Sub2</label>
                                          <input type="file" class="form-control" name="hinh3" >
                                    </div>
                                   
                                    
                                   

                                    <div class="form-group">
                                        <label>Phân loại</label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="trangthaiKM" value="true">Khuyến mãi
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="trangthaiHot" value="true">Hot
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="trangthaiTop" value="true">Top
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="trangthaiTopWeek" value="true">Top Week
                                        </label>
                                    </div>
                                    <button type="reset" class="btn btn-default">Nhập lại</button>
                                    <input type="hidden" name="command" value="insert">
                                    <input type="submit" class="btn btn-default" value="Lưu dữ liệu" >
                                    <a href="${root}/admin/quanlyproduct.jsp"  class="btn btn-default">Hủy bỏ</a>
                                </div>

                            </div>
                        </div> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
