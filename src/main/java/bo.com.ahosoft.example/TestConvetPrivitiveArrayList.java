package bo.com.ahosoft.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 04:12 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestConvetPrivitiveArrayList {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4 ,5 ,6, 7, 8, 9, 10};

        List<Integer> list = converIntArrayToList(number);
        System.out.println("list : " + list);

        System.out.println();

        list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);
    }

    private static List<Integer> converIntArrayToList(int[] number) {
        List<Integer> list = new ArrayList<>();
        for ( int i : number)
            list.add(i);

        return list;
    }
}
