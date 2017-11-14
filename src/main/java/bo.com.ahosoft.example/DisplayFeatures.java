package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 01:50 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class DisplayFeatures {
    private String size; // In inches
    private Optional<ScreenResolution> resolution;

    public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
        this.size = size;
        this.resolution = resolution;
    }
}
