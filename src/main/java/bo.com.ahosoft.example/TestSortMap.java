package bo.com.ahosoft.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 01:51 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestSortMap {
    public static void main(String[] args) {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortMap);

        // sort by keys, a, b, c...., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHasMap to keep the order

        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Not Recommend, but it works.
        // Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);

        // sort by values, and reserve it, 10,9,8,7,6...
        Map<String, Integer> result3 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldVaule, newValue) -> oldVaule, LinkedHashMap::new));

        Map<String, Integer> result4 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result3.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result3);
        System.out.println(result4);
    }
}
