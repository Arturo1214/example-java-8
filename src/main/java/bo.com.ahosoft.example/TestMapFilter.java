package bo.com.ahosoft.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 02:34 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestMapFilter {
    public static void main(String[] args) {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        String result = "";
        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue()))
                result = entry.getValue();
        }
        System.out.println("Before Java 8 : " + result);

        //Map -> Stream -> Filter ->String
        result = HOSTING.entrySet().stream()
                .filter(map -> "aws.amazon.com".equals(map.getValue()))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());

        System.out.println("With Java 8 : " + result);

        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(collect); //output : {2=heroku.com}
    }
}
