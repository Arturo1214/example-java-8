package bo.com.ahosoft.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 02:13 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestListMap {
    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000L));
        list.add(new Hosting(2, "linode.com", 90000L));
        list.add(new Hosting(3, "digitalocean.com", 120000L));
        list.add(new Hosting(4, "aws.amazon.com", 200000L));
        list.add(new Hosting(5, "mkyong.com", 1L));

        // key = id, value - websites
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getName));

        System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        System.out.println("Result 2 :" + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);

        list.add(new Hosting(6, "linode.com", 100000L)); // new line

        // key = name, value - websites, but the key 'linode' is duplicated!?
        Map<String, Long> result4 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldVaule, newValue) -> newValue));

        System.out.println("Result 4 : " +result4);

        // example 5
        Map result5 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new
                        )
                );

        System.out.println("Result 5 : " + result5);
    }
}
