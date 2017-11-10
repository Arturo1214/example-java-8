package bo.com.ahosoft.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class TestStreamMap {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha)
            alphaUpper.add(s.toUpperCase());

        System.out.println(alpha);
        System.out.println(alphaUpper);

        System.out.println();

        //Java8
        List<String> collect = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println();

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collectNum = num.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(num);
        System.out.println(collectNum);

        System.out.println();
        System.out.println();
        System.out.println();

        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff)
            result.add(x.getName());

        System.out.println(result);
        System.out.println();

        List<String> collectName = staff.stream()
                .map(Staff::getName)
                .collect(Collectors.toList());

        System.out.println(collectName);
        System.out.println();

        //Before Java 8
        List<StaffPublic> resultConvert = convertToStaffPublic(staff);
        System.out.println(resultConvert);

        //New Java 8
        resultConvert = staff.stream()
                .map(temp -> {
                    StaffPublic obj = new StaffPublic();
                    obj.setName(temp.getName());
                    obj.setAge(temp.getAge());
                    if("mkyong".equals(temp.getName()))
                        obj.setExtra("this field is for mkyong only!");

                    return obj;
                }).collect(Collectors.toList());

        System.out.println();
        System.out.println(resultConvert);

    }

    private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
        List<StaffPublic> result = new ArrayList<>();

        for (Staff temp : staff) {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName()))
                obj.setExtra("this field is for mkyong only!");

            result.add(obj);
        }

        return result;
    }
}
