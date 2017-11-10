package bo.com.ahosoft.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestForEachMap {
    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " +v);
            if("E".equals(k))
                System.out.println("Hello E");
        });


        List<String> itemsTwo = new ArrayList<>();
        itemsTwo.add("A");
        itemsTwo.add("B");
        itemsTwo.add("C");
        itemsTwo.add("D");
        itemsTwo.add("E");

        itemsTwo.forEach(System.out::println);

        itemsTwo.forEach(item -> {
            if ("C".equals(item))
                System.out.println(item);
        });

        itemsTwo.stream()
                .filter(s -> s.contains("B"))
                .forEach(System.out::println);

    }
}
