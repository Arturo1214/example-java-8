package bo.com.ahosoft.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 03:28 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestJoinArray {
    public static void main(String[] args) {
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};

        String[] result = joinArrayGeneric(s1, s2, s3);

        System.out.println(Arrays.toString(result));

        int[] int1 = new int[]{1, 2, 3};
        int[] int2 = new int[]{4, 5, 6};
        int[] int3 = new int[]{7, 8, 9};

        int[] result2 = joinArray(int1, int2, int3);

        System.out.println(Arrays.toString(result2));

        String [] result3 = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result3));

        // join primitive type array
        int[] result4 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();

        //join primitive type array, any better idea?
        int[] result5 = IntStream.concat(Arrays.stream(int1),
                IntStream.concat(Arrays.stream(int2), Arrays.stream(int3))).toArray();

        System.out.println(Arrays.toString(result4));
        System.out.println(Arrays.toString(result5));
    }

    static <T> T[] joinArrayGeneric(T[]... arrays) {
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }

        //T[] result = new T[length]
        final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

        int offset = 0;
        for (T[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    static int[] joinArray(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays)
            length += array.length;

        final int[] result = new int[length];

        int offset = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }
}
