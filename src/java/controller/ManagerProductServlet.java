/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Product;

/**
 *
 * @author SONPC
 */
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/ManagerProductServlet"})
public class ManagerProductServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        long maLoai = Long.valueOf(request.getParameter("maLoai"));
        String tenSanpham = request.getParameter("tenSanpham");
        long gia = Long.valueOf(request.getParameter("gia"));
        long giaKM = Long.valueOf(request.getParameter("giaKM"));
        String motaNgan = request.getParameter("motaNgan");
        String mota = request.getParameter("mota");
        String hinh1 = request.getParameter("hinh1");
        String hinh2 = request.getParameter("hinh2");
        String hinh3 = request.getParameter("hinh3");
        boolean stKM = Boolean.valueOf(request.getParameter("trangthaiKM"));
        boolean stHot = Boolean.valueOf(request.getParameter("trangthaiHot"));
        boolean stTop = Boolean.valueOf(request.getParameter("trangthaiTop"));
        boolean stNew = Boolean.valueOf(request.getParameter("trangthaiNew"));
        boolean stTopWeek = Boolean.valueOf(request.getParameter("trangthaiTopWeek"));
        boolean st = Boolean.valueOf(request.getParameter("trangthaiSanPham"));
        try {
            switch (command) {
                case "insert":
                    productDAO.insertProduct(new Product(new Date().getTime(), maLoai, tenSanpham,
                            gia, giaKM, motaNgan, mota, hinh1, hinh2, hinh3, stKM, stHot, stTop, true, stTopWeek, true));
                    break;
                case "update":
                    productDAO.updateProduct(new Product(Long.parseLong(request.getParameter("ID_Product")),
                            maLoai, tenSanpham, gia, giaKM, motaNgan, mota,
                            hinh1, hinh2, hinh3, stKM, stHot, stTop, stNew, stTopWeek, st));
                    break;
            }

        } catch (Exception e) {
        }
        response.sendRedirect("admin/quanlyproduct.jsp");
    }
}
