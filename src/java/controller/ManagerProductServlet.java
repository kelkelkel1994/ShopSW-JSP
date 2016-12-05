/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.*;
import com.oreilly.servlet.*;
import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Customer;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author SONPC
 */
@WebServlet(name = "ManagerProductServlet", urlPatterns = {"/ManagerProductServlet"})
@MultipartConfig()
public class ManagerProductServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
    private static String tentam = null;
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

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
// checks if the request actually contains upload file
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            // if not, we stop here
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: Form must has enctype=multipart/form-data.");
//            writer.flush();
//            return;
//        }
//
//        // configures upload settings
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        // sets memory threshold - beyond which files are stored in disk 
//        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        // sets temporary location to store files
//        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        // sets maximum size of upload file
//        upload.setFileSizeMax(MAX_FILE_SIZE);
//
//        // sets maximum size of request (include file + form data)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
//
//        // constructs the directory path to store upload file
//        // this path is relative to application's directory
//        String uploadPath = getServletContext().getRealPath("")
//                + File.separator + UPLOAD_DIRECTORY;
//
//        // creates the directory if it does not exist
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
//
//        try {
//
//            List<FileItem> formItems = upload.parseRequest(request);
//
//            if (formItems != null && formItems.size() > 0) {
//                // iterates over form's fields
//                for (FileItem item : formItems) {
//                    // processes only fields that are not form fields
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
//
//                        // saves the file on disk
//                        item.write(storeFile);
//                        request.setAttribute("msg", UPLOAD_DIRECTORY + "/" + fileName);
//                        request.setAttribute("message",
//                                "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            request.setAttribute("message",
//                    "There was an error: " + ex.getMessage());
//        }
        
//
//        MultipartRequest multi= new MultipartRequest(request,".",5*1024*1024);
//        multi.getParameter("maLoai");
//        PrintWriter writer = response.getWriter();
//            writer.println(multi.getParameter("maLoai"));
//        

       // UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        //MultipartRequest mutinew MultipartRequest(request,"upload");
       // Hashtable params=new Hashtable();
       
       MultipartRequest multi=new MultipartRequest(request,".",10*1024*1024,"UTF-8");
        
        File file = multi.getFile("uploadFile");
        File file1 = multi.getFile("hinh2");
        File file2 = multi.getFile("hinh3");
        String myfolder = getServletContext().getRealPath("upload") + "\\";
        //String link = myfolder + file.getName();
        file.renameTo(new File(myfolder, file.getName()));
        file1.renameTo(new File(myfolder, file1.getName()));
        file2.renameTo(new File(myfolder, file2.getName()));

       
        String command = multi.getParameter("command");
        long maLoai = Long.valueOf(multi.getParameter("maLoai"));
        String tenSanpham = multi.getParameter("tenSanpham");
        long gia = Long.valueOf(multi.getParameter("gia"));
        long giaKM = Long.valueOf(multi.getParameter("giaKM"));
        String motaNgan = multi.getParameter("motaNgan");
        String mota = multi.getParameter("mota");
        String hinh1 = file.getName();
        // String hinh1 = tentam;
        String hinh2 = file1.getName();
        String hinh3 = file2.getName();
        boolean stKM = Boolean.valueOf(multi.getParameter("trangthaiKM"));
        boolean stHot = Boolean.valueOf(multi.getParameter("trangthaiHot"));
        boolean stTop = Boolean.valueOf(multi.getParameter("trangthaiTop"));
        boolean stNew = Boolean.valueOf(multi.getParameter("trangthaiNew"));
        boolean stTopWeek = Boolean.valueOf(multi.getParameter("trangthaiTopWeek"));
        boolean st = Boolean.valueOf(multi.getParameter("trangthaiSanPham"));
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
