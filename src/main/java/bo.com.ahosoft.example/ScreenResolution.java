package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 01:47 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class ScreenResolution {
    private Integer width;
    private Integer height;

    public ScreenResolution(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

}
