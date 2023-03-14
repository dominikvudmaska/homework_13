import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer sum = Stream.iterate(1, A -> A + 1)
                .limit(10000)
                .filter(A -> A % 3 ==0
                        && A % 5 == 0
                        && A % 7 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        Stream.iterate(0, A -> A + 1)
                .limit(100)
                .filter(A -> A % 2 == 0)
                .forEach(A -> System.out.println(A));

        Book b1 = new Book("Na zapade nic nove", 14);
        Book b2 = new Book("Dennik z Wuhanu", 11);
        Book b3 = new Book("Harry Potter", 13);
        Book b4 = new Book("Encyklopedia", 120);
        Book b5 = new Book("Max", 17);

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(b1);
        listOfBooks.add(b2);
        listOfBooks.add(b3);
        listOfBooks.add(b4);
        listOfBooks.add(b5);

        Stream<Book> list = listOfBooks.stream();

        list.filter(A -> A.getPrice() < 100)
                .map(A -> A.getName())
                .sorted()
                .forEach(A -> System.out.println(A));

        Stream<Book> list2 = listOfBooks.stream();

        long count = list2.map(A -> A.getName())
                .filter(A -> A.length() < 5)
                .count();

        System.out.println(count);

        Stream<Book> list3 = listOfBooks.stream();

        OptionalDouble avg = list3.map(A -> A.getPrice())
                .mapToInt(Integer::intValue)
                .average();

        System.out.println(avg.getAsDouble());

        Stream<Book> list4 = listOfBooks.stream();
        boolean isPriceLow = list4.allMatch(A -> A.getPrice() < 500);

        System.out.println(isPriceLow);
    }

}