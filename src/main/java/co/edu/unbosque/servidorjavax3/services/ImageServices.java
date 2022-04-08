package co.edu.unbosque.servidorjavax3.services;

import co.edu.unbosque.servidorjavax3.Dtos.Pieza;
import co.edu.unbosque.servidorjavax3.Dtos.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class ImageServices {
    public Optional<List<Pieza>> getUsers() throws IOException {

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
}
