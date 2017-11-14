package bo.com.ahosoft.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 04:26 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestCheckArray {
    public static void main(String[] args) {
        String[] alphabet = new String[]{"A", "B", "C"};

        // Convert String Array to List
        List<String> list = Arrays.asList(alphabet);

        if (list.contains("A"))
            System.out.println("HELLO A");


        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        if (contains(number, 2))
            System.out.println("Hello 2");

        //Java 8
        boolean result = IntStream.of(number).anyMatch(x -> x == 4);

        if( result )
            System.out.println("Hello 4");
        else
            System.out.println("Where is number 4?");

        long[] lNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean result2 = LongStream.of(lNumber).anyMatch(x -> x == 10);

        if (result2)
            System.out.println("Hello 10");
        else
            System.out.println("Where in number 10?");
    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
}
