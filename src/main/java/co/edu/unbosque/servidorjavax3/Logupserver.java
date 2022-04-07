package co.edu.unbosque.servidorjavax3;

import co.edu.unbosque.servidorjavax3.Dtos.User;
import co.edu.unbosque.servidorjavax3.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logup", value = "/logup")
public class Logupserver extends HttpServlet {
    private UserService userservice;
    private User user;
    public Logupserver(){
        this.userservice = new UserService();
        this.user=new User();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setContentType("text/csv");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String rol=request.getParameter("rol");
        String fcoins=request.getParameter("fcoins");

        System.out.println(username+" este es el username");
        System.out.println(password+" este es el username");
        System.out.println(rol+" este es el rol");
        System.out.println(fcoins+" estos son los fcoins");


        boolean exist=false;
        System.out.println("linea 23");
        User n_usuario=new User();
        n_usuario.setPassword(password);
        n_usuario.setUsername(username);
        n_usuario.setRole(rol);
        n_usuario.setFcoins(fcoins);

        userservice.createUser(username, password,rol,fcoins, getServletContext().getRealPath("") + File.separator);
        System.out.println("esta linea es la que esta despues de el n_user creacion");

        RequestDispatcher dispatcher=request.getRequestDispatcher("./signedsucesfully.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
}
