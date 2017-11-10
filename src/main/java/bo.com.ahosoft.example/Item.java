package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 10-11-17 - 04:33 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class Item {
    private String name;
    private Integer qty;
    private BigDecimal price;

    public Item() {
    }

    public Item(String name, Integer qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
