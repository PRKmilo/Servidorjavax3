package co.edu.unbosque.servidorjavax3;

import co.edu.unbosque.servidorjavax3.Dtos.User;
import co.edu.unbosque.servidorjavax3.services.UserService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class Loginserver extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World! :V";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        List<User> Users= new UserService().getUsers().get();
          User userfound =Users.stream()
                .filter(user -> username.equals(user.getUsername()) && password.equals(user.getPassword()))
                .findFirst().get();
        if(username.equals(userfound.getUsername()) && password.equals(userfound.getPassword())){
            /*message= username + "welcome";
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");*/
            request.setAttribute("role",userfound.getRole());
            request.setAttribute("Fcoins",userfound.getFcoins());
            System.out.println("este es el rol "+userfound.getRole());
            RequestDispatcher dispatcher=request.getRequestDispatcher("./home.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("No autorizado viejo :c");
            response.sendRedirect("./401.html");
        }
        // Hello

    }

    public void destroy() {
    }
}