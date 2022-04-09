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
    public Optional<List<Pieza>> getPieces() throws IOException {

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
    public void create_peace(String titulo,String Fcoins,String artista,String img,String path) throws IOException{
        List<Pieza> listp=getPieces().get();
        Pieza nueva_pieza=new Pieza();
        nueva_pieza.setArtist(artista);
        nueva_pieza.setPrecio(Fcoins);
        nueva_pieza.setImg(img);
        nueva_pieza.setTitulo(titulo);
        listp.add(nueva_pieza);
        FileOutputStream os = new FileOutputStream(path + "WEB-INF/classes/" + "pieces.csv", true);
        String res="img,titulo,precio,artist";
        for(int i=0;i< listp.size();i++){
            res+="\n"+listp.get(i).getImg()+","+listp.get(i).getTitulo()+","+listp.get(i).getPrecio()+","+listp.get(i).getArtist();
        }
        os.write(res.getBytes());
        os.close();
    }
}
