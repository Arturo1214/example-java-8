package bo.com.ahosoft.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 03:12 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestConvertMapToList {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result = new ArrayList<>(map.keySet());
        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
        List<String> result2 = new ArrayList<>(map.values());
        result2.forEach(System.out::println);

        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result3 = map.keySet().stream().collect(Collectors.toList());
        result3.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
        List<String> result4 = map.values().stream().collect(Collectors.toList());
        result4.forEach(System.out::println);

        System.out.println("\n3. Export Map Value to List..., say no to banana");
        List<String> result5 = map.values().stream()
                .filter(x ->!"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        result5.forEach(System.out::println);

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(Map.Entry::getValue)
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);
    }
}
