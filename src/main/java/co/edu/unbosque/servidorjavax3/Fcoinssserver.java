package co.edu.unbosque.servidorjavax3;

import co.edu.unbosque.servidorjavax3.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "fcoins", value = "/fcoins")
public class Fcoinssserver extends HttpServlet {
    private UserService userservice;
    public Fcoinssserver(){
        this.userservice=new UserService();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("esta es la linea 19 de servelets fcoins");
        response.setContentType("text/html");
        System.out.println("esta pasando en el servidor de Fcoinsserver");
        String Username=request.getParameter("username");
        String password=request.getParameter("password");
        String Fcoins=request.getParameter("fcoins");
        request.setAttribute("username",Username);
        userservice.mandarfcoins(Username,password,Fcoins,getServletContext().getRealPath("") + File.separator);
        RequestDispatcher dispatcher=request.getRequestDispatcher("./LoadS.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
