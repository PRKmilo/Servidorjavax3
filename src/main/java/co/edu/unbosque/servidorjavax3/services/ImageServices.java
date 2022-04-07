package co.edu.unbosque.servidorjavax3.services;

import co.edu.unbosque.servidorjavax3.Dtos.Pieza;
import co.edu.unbosque.servidorjavax3.Dtos.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class ImageServices {
    public Optional<List<Pieza>> getPiezas() throws IOException {

        List<Pieza> piezas;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("/pieza.csv")) {

            if (is == null) {
                return Optional.empty();
            }

            HeaderColumnNameMappingStrategy<Pieza> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Pieza.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                System.out.println(br.toString()+" este es el br");
                System.out.println(is.toString()+" este es el is");
                System.out.println();
                CsvToBean<Pieza> csvToBean = new CsvToBeanBuilder<Pieza>(br)
                        .withType(Pieza.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                piezas = csvToBean.parse();

            }
        }

        return Optional.of(piezas);
    }

    public void createpiece(String titulo,String precio,String user,String img,String path)throws IOException{
        List<Pieza> listap=getPiezas().get();
        Pieza nueva_pieza=new Pieza();
        nueva_pieza.setTitulo(titulo);
        nueva_pieza.setUser(user);
        nueva_pieza.setPrecio(precio);
        nueva_pieza.setImg(img);
        listap.add(nueva_pieza);
        FileOutputStream os = new FileOutputStream(path + "WEB-INF/classes/" + "pieza.csv", false);
        String res2="titulo,precio,user,img";
        for(int i=0;i< listap.size();i++){
            res2+="\n"+(listap.get(i).getTitulo()+","+listap.get(i).getUser()+","+listap.get(i).getPrecio()+","+listap.get(i).getImg());
        }
        os.write(res2.getBytes());
        os.close();
    }
}
