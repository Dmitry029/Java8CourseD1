package streamAndlambda.Task1;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> checkAge = Main::isAdult;
        Consumer<String> errorMessage = System.out::println;

    }

    private static boolean isAdult (Integer age){
        return age > 18;
    }


}








