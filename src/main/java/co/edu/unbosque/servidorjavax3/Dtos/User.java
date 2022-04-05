package co.edu.unbosque.servidorjavax3.Dtos;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
public class User {
    @CsvBindByName
    private String username;

    @CsvBindByName
    private String password;

    @CsvBindByName
    private String role;

    @CsvBindByName
    private String Fcoins;

    public User(String nombre, String clave, String papel, String moneda){
        this.username= nombre;
        this.Fcoins = moneda;
        this.password = clave;
        this.role = papel;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFcoins() {
        return Fcoins;
    }

    public void setFcoins(String fcoins) {
        Fcoins = fcoins;
    }
    @Override
    public String toString() {
        return String.format(getUsername(),getRole(),getPassword(),getFcoins());
    }
    public String[] toarray() {
        String[] array_string = new String[] {getUsername(),getRole(),getPassword(),getFcoins()};
        return array_string ;
    }

    public  void  wrietcsv2(User nuevo_usuario) throws IOException {
        System.out.println("este es el username,password etc "+nuevo_usuario.getUsername()+nuevo_usuario.getPassword()+nuevo_usuario.getRole()+nuevo_usuario.getFcoins());
        User javier = new User("usuario",nuevo_usuario.getPassword(),nuevo_usuario.getRole(),nuevo_usuario.getFcoins());
        ArrayList<User> usuario = new ArrayList<>();
        CSVWriter csvWriter = new CSVWriter(new FileWriter("usuarios6.csv"));
        usuario.add(javier);

        for (User ususer : usuario){
            csvWriter.writeNext(ususer.toarray());
        }
        System.out.println("se supone que deberia estar escribiendo en el archivo");
        csvWriter.close();
    }

}
