package bo.com.ahosoft.example;

import java.util.Random;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 02:12 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(getRandomNumberInRange(5, 10));

        System.out.println();

        for (int i = 0; i < 10; i++)
            System.out.println(getRandomNumberInRange2(5, 10));

        for (int i = 0; i < 10; i++)
            System.out.println(getRamdomNumberInRange3(5, 10));


        new Random().ints(10, 33, 38).forEach(System.out::println);
    }

    private static int getRandomNumberInRange(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return  r.nextInt((max - min) +1 ) + min;
    }

    private static  int getRandomNumberInRange2(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        return (int) (Math.random() * ((max -min) +1)) + min;
    }

    //Java 8

    private static int getRamdomNumberInRange3(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max +1)).limit(1).findFirst().getAsInt();
    }
}
