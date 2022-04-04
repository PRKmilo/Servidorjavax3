package co.edu.unbosque.servidorjavax3;

import co.edu.unbosque.servidorjavax3.Dtos.User;
import co.edu.unbosque.servidorjavax3.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logup", value = "/logup")
public class Logupserver extends HttpServlet {
    private UserService userservice;
    public Logupserver(){
        this.userservice = new UserService();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String rol=request.getParameter("rol");
        System.out.println(username+" este es el username");
        System.out.println(password+" este es el username");
        System.out.println(rol+" este es el username");

        boolean exist=false;
        System.out.println("linea 23");
        User n_usuario=new User();
        n_usuario.setPassword(password);
        n_usuario.setUsername(username);
        n_usuario.setRole(rol);
        userservice.WriteCvs(n_usuario);
        System.out.println("esta linea es la que esta despues de el n_user creacion");

        RequestDispatcher dispatcher=request.getRequestDispatcher("./home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
}
