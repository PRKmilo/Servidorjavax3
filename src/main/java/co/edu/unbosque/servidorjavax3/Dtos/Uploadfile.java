package co.edu.unbosque.servidorjavax3.Dtos;

import java.io.*;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "uploadFile", value = "/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class Uploadfile extends HttpServlet {
    private String UPLOAD_DIRECTORY = "uploads";

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Extracting parameters other than uploaded file
        System.out.println("Name: " + request.getParameter("name"));
        System.out.println("esta es la linea 24 ");
        // Getting an instance of the upload path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

        System.out.println(uploadPath+ " esta es la ruta ");
        File uploadDir = new File(uploadPath);

        // If path doesn`t exist, create it
        if (!uploadDir.exists()) uploadDir.mkdir();

        try {
            // Getting each part from the request
            for (Part part : request.getParts()) {
                // Storing the file using the same name
                String fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Redirecting
        response.sendRedirect("./resultado.html");
    }

    public void destroy() {}
}