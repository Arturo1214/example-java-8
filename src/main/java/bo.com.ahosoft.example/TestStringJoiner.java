package bo.com.ahosoft.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 02:48 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestStringJoiner {
    public static void main(String[] args) {
        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result = list.stream().map(x -> x.getName()).collect(Collectors.joining(",", "{", "}"));
        System.out.println(result);
        result = list.stream().map(x -> x.getName()).collect(Collectors.joining(" | "));
        System.out.println(result);
    }
}
