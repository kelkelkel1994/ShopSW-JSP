/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.oreilly.servlet.MultipartRequest;
import dao.SlideDAO;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Slide;

/**
 *
 * @author SONPC
 */
@WebServlet(name = "ManagerSlideServlet", urlPatterns = {"/ManagerSlideServlet"})
public class ManagerSlideServlet extends HttpServlet {

    SlideDAO slideDAO=new SlideDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        MultipartRequest multi = new MultipartRequest(request, ".", 10 * 1024 * 1024, "UTF-8");
        String command = multi.getParameter("command");
        String img = null;
                File file = multi.getFile("img12");
                String myfolderb = getServletContext().getRealPath("upload") + "\\";
                if (file == null) {
                    img = multi.getParameter("tenImg");
                } else {
                    img = file.getName();
                    file.renameTo(new File(myfolderb, file.getName()));
                }
                long display = Long.valueOf(multi.getParameter("tenDisplay"));
        String link = multi.getParameter("tenLink");
        String description = multi.getParameter("tenDescription");
        boolean st=Boolean.valueOf(multi.getParameter("trangthai"));
        try {
            
                switch (command) {
                    case "update":
                        slideDAO.updateSlide(new Slide(1,img,display,link,description,st));
                        break;
                }
          
        } catch (Exception e) {
        }            
  
        response.sendRedirect("admin/suaslide.jsp");
    }

   

}
