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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String rol=request.getParameter("rol");
        boolean exist=false;
        List<User> Users= new UserService().getUsers().get();
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getUsername().equals(username)){
                exist=true;
            }
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher("./home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
}
