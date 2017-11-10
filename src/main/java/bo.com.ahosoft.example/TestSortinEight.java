package bo.com.ahosoft.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestSortinEight {
    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer: listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda here!
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

        listDevs.forEach(developer -> System.out.println(developer));

        System.out.println("After Sort");
        System.out.println();
        System.out.println("Sort by Age");
        //lambda here!
        listDevs.sort(Comparator.comparingInt(Developer::getAge));
        listDevs.forEach(System.out::println);

        System.out.println();
        System.out.println("Sort by Name");
        listDevs.sort(Comparator.comparing(Developer::getName));
        listDevs.forEach(System.out::println);

        System.out.println();
        System.out.println("Sort by Salary");
        listDevs.sort(Comparator.comparing(Developer::getSalary).reversed());
        listDevs.forEach(System.out::println);
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }
}
