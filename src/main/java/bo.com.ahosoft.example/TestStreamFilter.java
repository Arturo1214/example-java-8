package bo.com.ahosoft.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestStreamFilter {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("sprint", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result)
            System.out.println(temp);

        System.out.println();

        result = lines.stream()
                .filter(line -> !"mkyong".equals(line))
                .collect(Collectors.toList());

        result.forEach(System.out::println);


        System.out.println();
        System.out.println();
        System.out.println();

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person resultPerson = getStudenByName(persons, "jack");
        System.out.println(resultPerson);

        System.out.println();
        System.out.println();

        resultPerson = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(resultPerson);

        System.out.println();
        System.out.println();

        resultPerson = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);
        System.out.println(resultPerson);

        System.out.println();
        System.out.println();

        resultPerson = persons.stream()
                .filter(p -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println();
        System.out.println(resultPerson);

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)
                .findAny()
                .orElse("");

        System.out.println();
        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println();
        collect.forEach(System.out::println);
    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!filter.equals(line))
                result.add(line);
        }
        return result;
    }

    private static Person getStudenByName(List<Person> persons, String name) {
        Person result = null;
        for (Person temp : persons)
            if (name.equals(temp.getName()))
                result = temp;

        return result;
    }
}
