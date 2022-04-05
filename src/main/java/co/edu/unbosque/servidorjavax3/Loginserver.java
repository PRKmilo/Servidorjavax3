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
        System.out.println("este es el username del request"+ username);
        List<User> Users= new UserService().getUsers().get();
        boolean res=false;
        for(int i=0;i<Users.size();i++){
            if(Users.get(i).getUsername().equals(username) && Users.get(i).getPassword().equals(password)){
                res=true;
            }
        }
        System.out.println("esta es la linea antes de hacer el res== true");
          if(res == true){
              User userfound =Users.stream()
                      .filter(user -> username.equals(user.getUsername()) && password.equals(user.getPassword()))
                      .findFirst().get();
              System.out.println("linea despues de userfound");
              System.out.println("este es el getproperty role de user found "+userfound.getRole() );
              if(userfound.getRole().equals("Artist")){
                  request.setAttribute("role",userfound.getRole());
                  request.setAttribute("Fcoins",userfound.getFcoins());
                  System.out.println("este es el rol "+userfound.getRole());
                  RequestDispatcher dispatcher=request.getRequestDispatcher("./Artista.jsp");
                  try {
                      dispatcher.forward(request, response);
                  } catch (ServletException e) {
                      e.printStackTrace();
                  }
              }else if(userfound.getRole().equals("Costumer")){
                  request.setAttribute("role",userfound.getRole());
                  request.setAttribute("Fcoins",userfound.getFcoins());
                  System.out.println("este es el rol "+userfound.getRole());
                  RequestDispatcher dispatcher=request.getRequestDispatcher("./comprador.jsp");
                  try {
                      dispatcher.forward(request, response);
                  } catch (ServletException e) {
                      e.printStackTrace();
                  }
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