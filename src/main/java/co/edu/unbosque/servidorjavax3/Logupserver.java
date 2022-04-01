package co.edu.unbosque.servidorjavax3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logup", value = "/logup")
public class Logupserver extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
