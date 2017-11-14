package bo.com.ahosoft.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-11-17 - 02:57 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
@Getter @Setter @ToString
public class Student {
    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null)
            this.book = new HashSet<>();
        this.book.add(book);
    }
}
