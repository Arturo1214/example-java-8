package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 02:48 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class Game {
    private String name;
    private Integer ranking;

    public Game(String name, Integer ranking) {
        this.name = name;
        this.ranking = ranking;
    }
}
