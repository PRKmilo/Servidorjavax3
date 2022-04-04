package co.edu.unbosque.servidorjavax3.services;

import co.edu.unbosque.servidorjavax3.Dtos.User;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserService {
    public Optional<List<User>> getUsers() throws IOException {

        List<User> users;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("/users.csv")) {

            if (is == null) {
                return Optional.empty();
            }

            HeaderColumnNameMappingStrategy<User> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(User.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                System.out.println(br.toString()+" este es el br");
                System.out.println(is.toString()+" este es el is");
                System.out.println();
                CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(br)
                        .withType(User.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                users = csvToBean.parse();

            }
        }

        return Optional.of(users);
    }
    public void WriteCvs(User nuevo_usuario) throws IOException {

        File file = new File("../resources/users.csv");
        List<User> Users= getUsers().get();
        System.out.println("este es el nomre del usuario desde el wrutecvs "+nuevo_usuario.getUsername());
        Users.add(nuevo_usuario);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file,false);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Name", "Class", "Marks" };
            writer.writeNext(header);
            System.out.println("esta es la linea de 65 con el nimbre del nuevo usuario" +nuevo_usuario.getUsername());
            // add data to csv
           for(int i=0;i<Users.size();i++){
               String[] next= {Users.get(i).getUsername(), Users.get(i).getPassword(), Users.get(i).getRole()};
               writer.writeNext(next);
               System.out.println(next+" este es el next de cada linea y el username "+Users.get(i).getUsername());
           }

            // closing writer connection
            writer.close();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
