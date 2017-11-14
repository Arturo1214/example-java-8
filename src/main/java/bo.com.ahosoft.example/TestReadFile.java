package bo.com.ahosoft.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 03:04 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestReadFile {
    public static void main(String[] args) {
        ///home/arturo/Documentos/lines.txt

        //after java 8
        String fileName = "/home/arturo/Documentos/lines.txt";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        list.forEach(System.out::println);

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        list.forEach(System.out::println);
    }
}
