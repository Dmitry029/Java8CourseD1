package streamAndlambda.Task2;

import java.awt.*;
import java.util.List;

public class Author {
    private String name;
    private short age;
    private List<Book> books;

    public Author(String name, short age, List<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    @Override
    public String toString() {
        return " " + name + " ";
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }
}
