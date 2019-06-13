import beans.Person;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        Person dev1 = new Person("Vasja", 22);
        Person dev2 = new Person("Sanija", 28);
        Person dev3 = new Person("Igar", 30);
        Person dev4 = new Person("Goga", 22);

        List<Person> persons = Arrays.asList(dev1, dev2, dev3, dev4);

        persons.stream().sorted(comparing(Person::getName))
                .forEach(System.out::println);
        System.out.println("********");
        persons.stream().sorted(comparing(Person::getAge))
                .forEach(System.out::println);
    }


}








