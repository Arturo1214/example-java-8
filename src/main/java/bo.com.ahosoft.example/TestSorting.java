package bo.com.ahosoft.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestSorting {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer: listDevs) {
            System.out.println(developer);
        }

        System.out.println();
        System.out.println("*******************************");
        System.out.println("**************SORT BY AGE******************");
        //sort by age
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println();
        System.out.println("After Sort");
        for (Developer developer: listDevs) {
            System.out.println(developer);
        }

        System.out.println();
        System.out.println("*******************************");
        System.out.println("**************SORT BY NAME******************");
        //sort by name
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println();
        System.out.println("After Sort");
        for (Developer developer: listDevs) {
            System.out.println(developer);
        }

        System.out.println();
        System.out.println("*******************************");
        System.out.println("**************SORT BY SALARY******************");
        //sort by salary
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });

        System.out.println();
        System.out.println("After Sort");
        for (Developer developer: listDevs) {
            System.out.println(developer);
        }

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
