package org.certification.stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAssignment {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
        q7();
        q8();
        q9();
        q10();
        q11();
        q12();
        q13();
        q14();
    }

    public static void q1() {
        IntStream.rangeClosed(0, 5).average().ifPresent(System.out::println);
    }

    public static void q2() {
        List<Item> itens = Arrays.asList(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));
        itens.stream().map(Item::getName).sorted().forEach(System.out::print);
    }

    public static void q3() {
        Stream<List<String>> list = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        list.filter(l -> l.contains("c")).flatMap(List::stream).forEach(System.out::print);
    }

    public static void q4() {
        //a)
        System.out.println(IntStream.of(1, 2, 3).sum());
        IntStream.of(1, 2, 3).max().ifPresent(System.out::println);
        //b)
        List<Person> people = Arrays.asList(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        //c)
        List<Integer> list = Arrays.asList(10, 47, 33, 23);
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        list = Arrays.asList(10, 47, 33, 23);
        System.out.println(list.stream().reduce(0, Integer::sum));
    }

    public static void q5() {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(5);

        System.out.println(grade1.orElse("UNKNOWN"));
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::println);
        } else {
            grade2.orElse("Empty");
        }
    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");
        }
        return grade;
    }

    public static void q6() {
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30),
                new Book("Java in 24 hrs", 20),
                new Book("Java Recipes", 10)
        );

        books.stream().filter(b -> b.getPrice() > 10).mapToDouble(Book::getPrice).average().ifPresent(System.out::println);
        books.stream().filter(b -> b.getPrice() > 90).mapToDouble(Book::getPrice).average().ifPresent(System.out::println);
    }

    public static void q7() {
        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        books.stream().collect(Collectors
                        .toMap(Book::getTitle, Book::getPrice))
                .entrySet().stream().filter(mb -> mb.getKey().startsWith("A")).forEach(System.out::println);
    }

    public static void q8() {
        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        );
        try {
            //this way is not prepared to lead to a duplicate key exception, because we have two books with the same title,
            // so we need to provide a merge function to handle the duplicate keys
            books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice)).forEach(
                    (title, price) -> System.out.println(title + " " + price)
            );
        } catch (Exception e) {
            books.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice, (s1, s2) -> s1)).forEach(
                    (title, price) -> System.out.println(title + " " + price)
            );
        }
    }

    public static void q9() {

        List<Person> people = Arrays.asList(
                new Person("Bob", "", 31),
                new Person("Paul", "", 32),
                new Person("John", "", 33));
        Double avarage = people.stream().filter(p -> p.getAge() < 30).mapToInt(Person::getAge).average().orElse(0.0);
        System.out.println(avarage);

    }
    public static void q10() {
//a)
      Optional<Double> price = Optional.ofNullable(20.0);
      price.ifPresent(p -> System.out.println("Price is: " + p));
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));
//b)
      Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println(price2);
        if(price2.isEmpty()){
            System.out.println("empty");
        }
        price2.ifPresent(System.out::println);
        Double x = price2.orElse(44.0);
        System.out.println(x);

        //c)
        try {
            Optional<Double> price3 = Optional.ofNullable(null);
            Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
            System.out.println(z);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void q11() {
        List<AnotherBook> books = Arrays.asList(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        List<String> genreList = new ArrayList<>();
//        genreList = books.stream().map(AnotherBook::getGenre).toList();
         books.stream().map(AnotherBook::getGenre).forEach(genreList::add);
        Map<String, Long>  mapGrouped = books.stream().collect(Collectors.groupingBy(AnotherBook::getGenre, Collectors.counting()));
        System.out.println(genreList);
        System.out.println(mapGrouped);
    }
    public static void q12() {
        //a)
        System.out.println(DoubleStream.of(0.0,2.0,4.0).mapToInt(v->(int)v).filter(v->v%2 != 0).sum());
        //b)
       DoubleStream.of(1.0,3.0).map(v->(double)v).average().ifPresent(System.out::println);
    }

    public static void q13() {
        List<Integer> list =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        //a)
        System.out.println(list.stream().distinct().anyMatch(l->l==11));
        //b)
        list =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        System.out.println(list.stream().noneMatch(l->l%11>0));

    }
    public static void q14() {
        //a)
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11,11,22,33).parallel().filter(n->{
            ai.incrementAndGet();
            return n%2 == 0;
        }).count();
        System.out.println(ai);
//b)
        try {
            Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();

            stream = stream.filter(n -> {
                ai.incrementAndGet();
                return n % 2 == 0;
            });
            stream.forEach(System.out::println);
            System.out.print(ai);
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
    }

}
