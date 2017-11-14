package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 02:11 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class Hosting {

    private Integer id;
    private String name;
    private Long websites;

    public Hosting(Integer id, String name, Long websites) {
        this.id = id;
        this.name = name;
        this.websites = websites;
    }
}
