package co.edu.unbosque.servidorjavax3.Dtos;

import com.opencsv.bean.CsvBindByName;

public class Pieza {
    @CsvBindByName
    private String titulo;

    @CsvBindByName
    private String precio;

    @CsvBindByName
    private String user;

    @CsvBindByName
    private String img;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
