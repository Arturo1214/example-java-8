package bo.com.ahosoft.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 02:48 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestFlatMap {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = temp.filter(x -> "a".equals(Arrays.toString(x)));

        stream.forEach(System.out::println);

        Stream<String[]> temp1 = Arrays.stream(data);
        Stream<String> stringStream = temp1.flatMap(Arrays::stream);

        Stream<String> stream1 = stringStream.filter("a"::equals);

        stream1.forEach(System.out::println);


        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                list.stream()
                .map(x -> x.getBook())
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(Arrays::stream);
        intStream.forEach(System.out::println);
    }
}
