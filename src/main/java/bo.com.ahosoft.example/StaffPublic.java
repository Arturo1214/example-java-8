package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class StaffPublic {
    private String name;
    private Integer age;
    private String extra;

    public StaffPublic() {}

    public StaffPublic(String name, Integer age, String extra) {
        this.name = name;
        this.age = age;
        this.extra = extra;
    }
}
