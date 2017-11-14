package bo.com.ahosoft.example;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 04:00 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestStringToCharArray {
    public static void main(String[] args) {
        String password = "password123";
        char[] passwordInCharArray = password.toCharArray();

        for (char temp : passwordInCharArray)
            System.out.println(temp);

        System.out.println();
        password.chars()
                .mapToObj(x -> (char) x)
                .forEach(System.out::println);
    }
}
