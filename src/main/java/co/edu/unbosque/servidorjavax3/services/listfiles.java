package co.edu.unbosque.servidorjavax3.services;


import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "listFiles", value = "/list-files")
public class listfiles extends HttpServlet {
    private String UPLOAD_DIRECTORY = "uploads";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



        // Specifying the content type for the response
        response.setContentType("application/json");
        System.out.println("fiel en doget de la linea 25");
        // Getting an instance of the upload path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        // Listing file names in path
        List<String> files = new ArrayList<String>();



        for (File file : uploadDir.listFiles()) {
            
            String nuevoarchivo=crear();
            File file2 = new File(nuevoarchivo);
            files.add(UPLOAD_DIRECTORY + File.separator + file.getName());

            System.out.println("esta es la imagen "+file.renameTo(file2));

        }

        // Adding the data to response, parsing it to json using Gson library
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(files));
    }

    public String crear(){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}