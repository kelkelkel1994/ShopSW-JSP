/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImformationDAO;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Imformation;

/**
 *
 * @author SONPC
 */
@WebServlet(name = "ManagerInfomationServlet", urlPatterns = {"/ManagerInfomationServlet"})
public class ManagerInfomationServlet extends HttpServlet {
ImformationDAO informationDAO=new ImformationDAO();
 
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
        String logo = request.getParameter("tenLogo");
        String hotline = request.getParameter("tenHotline");
        String facebook = request.getParameter("tenFacebook");
        String facebooklink = request.getParameter("tenLinkFacebook");
        String timeopen = request.getParameter("tenTimeopen");
        String address = request.getParameter("tenAddress");
        String email = request.getParameter("tenEmail");
        String sitename = request.getParameter("tenSitename");
        String mota = request.getParameter("tenMota");
        String icon = request.getParameter("tenIcon");
        String keyword = request.getParameter("tenKeyword");
        String googleapi = request.getParameter("tenGoogle");
        String xgoogle = request.getParameter("tenXGoogle");
        String ygoogle = request.getParameter("tenYGoogle");
        boolean sthot=Boolean.valueOf(request.getParameter("trangthaiHot"));
        boolean stnew=Boolean.valueOf(request.getParameter("trangthaiNew"));
        boolean sttopweek=Boolean.valueOf(request.getParameter("trangthaiTopWeek"));
        try {
            
                switch (command) {
                    case "update":
                        informationDAO.updateThongtin(new Imformation(1,logo,hotline,facebook,facebooklink,timeopen,address,email,
                                sitename, mota, icon, keyword, googleapi, xgoogle, ygoogle, sthot, stnew, sttopweek));
                        
                        break;
                }
          
        } catch (Exception e) {
        }            
  
        response.sendRedirect("admin/suathongtin.jsp");

        
        //RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        //rd.forward(request, response);
        //request.setAttribute("alertMsg", "Sửa thành công");
       // RequestDispatcher rd=request.getRequestDispatcher("admin/suathongtin.jsp");  
        //rd.include(request, response);
//        processRequest(request, response);
    }

  
}
