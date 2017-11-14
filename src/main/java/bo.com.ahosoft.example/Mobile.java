package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 01:51 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class Mobile {
    private Long id;
    private String brand;
    private String name;
    private Optional<DisplayFeatures> displayFeatures;
    // Likewise we can see Memory Features, Camera Features etc.


    public Mobile(Long id, String brand, String name, Optional<DisplayFeatures> displayFeatures) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.displayFeatures = displayFeatures;
    }
}
