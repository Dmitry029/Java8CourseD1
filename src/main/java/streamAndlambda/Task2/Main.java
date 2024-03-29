package streamAndlambda.Task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Author author1 = null;
        Author author2 = null;
        Author author3 = null;
        Author author4 = null;

        Book book1 = new Book("Wore and peace", (List<Author>) author1, 610);
        Book book2 = new Book("Anna Karenina", (List<Author>) author1, 410);
        Book book3 = new Book("Kazaki", (List<Author>) author1, 190);
        Book book4 = new Book("Idiot", (List<Author>) author2, 310);
        Book book5 = new Book("Besy", (List<Author>) author2, 180);
        Book book6 = new Book("Bratija Karamazovy", (List<Author>) author2, 520);
        Book book7 = new Book("12 chairs", Arrays.asList(author3, author4), 320);

        author1 = new Author("Tolstoy", (short) 82, Arrays.asList(book1, book2, book3));
        author2 = new Author("Dostoevsky", (short) 59, Arrays.asList(book4, book5, book6));
        author3 = new Author("Ilf", (short) 38, Arrays.asList(book7));
        author4 = new Author("Petrov", (short) 38, Arrays.asList(book7));

        book1.setAuthors(Arrays.asList(author1));
        book2.setAuthors(Arrays.asList(author1));
        book3.setAuthors(Arrays.asList(author1));
        book4.setAuthors(Arrays.asList(author2));
        book5.setAuthors(Arrays.asList(author2));
        book6.setAuthors(Arrays.asList(author2));
        book7.setAuthors(Arrays.asList(author3, author4));


        Book[] booksInLib = {book1, book2, book3, book4, book5, book6, book7};
        Author[] authorsINLib = {author1, author2, author3};

        boolean answer = Arrays.stream(booksInLib).anyMatch(book -> book.getNumberOfPages() > 200);
        if (answer) {
            System.out.println("There is book that has more then 200 pages.");
        } else {
            System.out.println("There is not book that has more then 200 pages.");
        }

        System.out.println("*** book with max number of pages ***  ");
        System.out.println(Arrays.stream(booksInLib).max(Comparator.comparing(Book::getNumberOfPages)).get());
        System.out.println("*** books with min number of pages ***  ");
        System.out.println(Arrays.stream(booksInLib).min(Comparator.comparing(Book::getNumberOfPages)).get());

        System.out.println("*** books with only single author ***  ");
        Arrays.stream(booksInLib)
                .filter(b -> b.getAuthors().size() == 1)
                .forEach(System.out::println);

        System.out.println("*** sort the books by number of pages ***");
        Arrays.stream(booksInLib).sorted(Comparator.comparing(Book::getNumberOfPages)).forEach(System.out::println);

        System.out.println("*** sort the books by title ***");
        Arrays.stream(booksInLib)
                .peek(b -> System.out.println(b.getTitle()))
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);

        System.out.println("*** list of all titles ***");
        Arrays.stream(booksInLib).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("*** distinct list of all authors ***");
        Arrays.stream(booksInLib).map(Book::getAuthors).distinct().forEach(System.out::println);
    }
}
