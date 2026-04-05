package org.certification.funcionalinterfaces;


import org.certification.funcionalinterfaces.domain.Evaluate;
import org.certification.funcionalinterfaces.domain.Functionable;
import org.certification.funcionalinterfaces.domain.Printable;
import org.certification.funcionalinterfaces.domain.Retrievable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BasicLambdas {
    private static final Consumer<String> separator = System.out::println;
    public static void main(String[] args) {
        BasicLambdas basicLambdas = new BasicLambdas();
        basicLambdas.consumer();
        separator.accept("----------------------------");
        basicLambdas.suplier();
        separator.accept("----------------------------");
        basicLambdas.predicate();
        separator.accept("----------------------------");
        basicLambdas.check(4,i->i%2==0);
        basicLambdas.check(7,i->i%2==0);
        basicLambdas.check("Mr.", "Mr. joe Bloggs"::startsWith);
        basicLambdas.check("Ms.", "Mr. Ann Bloggs"::startsWith);

        Person person1 = new Person("Mike",33,1.8);
        Person person2 = new Person("Ann",13,1.4);
        Stream.of(person1,person2).forEach(p->basicLambdas.check(p.getAge(),i->i>=18));
        separator.accept("----------------------------");
        basicLambdas.function();
        separator.accept("----------------------------");
        List<Person> listPeople = basicLambdas.getPeople();
        basicLambdas.sortAge(listPeople);
        separator.accept("----------------------------");
        basicLambdas.sortName(listPeople);
        separator.accept("----------------------------");
        basicLambdas.sortHeight(listPeople);

    }
    private void sortHeight(List<Person> people){
       // people.sort((p1,p2)->p1.getHeight().compareTo(p2.getHeight()));
        people.sort(Comparator.comparing(Person::getHeight));
        people.sort(Comparator.comparing(Person::getHeight));
        people.forEach(System.out::println);
    }
    private void sortName(List<Person> people){
//        people.sort((p1,p2)->p1.getName().compareTo(p2.getName()));
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(p->System.out.printf("Name: %s, Age: %d, Height: %.2f \n",p.getName(),p.getAge(),p.getHeight()));
    }
    private void sortAge(List<Person> people){
//        people.sort((p1,p2)->p1.getAge().compareTo(p2.getAge()));
        people.sort(Comparator.comparing(Person::getAge));
        people.forEach(p->System.out.printf("Name: %s, Age: %d, Height: %.2f \n",p.getName(),p.getAge(),p.getHeight()));
    }


    private List<Person> getPeople(){
       List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));

        result.add(new Person("Mary", 25, 1.4));

        result.add(new Person("Alan", 34, 1.7));

        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    public void function(){
        Functionable<Integer, String> funcionable = i->"Number is: "+i;
        System.out.println(funcionable.applyThis(25));

        Function<Integer, String> function2 = i->"Number is: "+i;
        System.out.println(function2.apply(25));
    }

    public  <T> void  check(T t, Predicate<T> predicate){
        System.out.println(predicate.test(t));
    }

    private  void predicate() {
        Evaluate<Integer> evaluate1 = i->i<0;
        System.out.println(evaluate1.isNegative(-1));
        System.out.println(evaluate1.isNegative(1));

        Predicate<Integer> predicate = i->i<0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));

    }

    public  void suplier(){
        Retrievable<Integer> retrievable = () -> 77 ;
        System.out.println(retrievable.retrieve());

        Supplier<Integer> supplier = ()-> 77;
        System.out.println(supplier.get());
    }

    public  void consumer(){
        Printable<String> printable = System.out::println;
        printable.print("Printable lambda");

        Consumer<String> consumer1 = s-> System.out.println(s);
        consumer1.accept("Printable lambda");


        Consumer<String> consumer2 =  System.out::println;
        consumer1.accept("Printable lambda");
    }


}
