package org.certification.methodReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        var LambdasAndMethodReferences = new LambdasAndMethodReferences();
//        staticMR();
//        LambdasAndMethodReferences.boundMR();
//        LambdasAndMethodReferences.unboundMR();
        LambdasAndMethodReferences.constructorMR();
    }

    public static void staticMR(){
        List<Integer> list = new ArrayList<>(
        List.of(1,2,7,4,5));
        Consumer<List<Integer>> sort1 = l-> Collections.sort(l);
        sort1.accept(list);
        list.forEach(System.out::println);
        list = new ArrayList<>(
                List.of(1,2,7,4,5));
        Consumer<List<Integer>> sort = Collections::sort;
        sort.accept(list);
        list.forEach(System.out::println);
    }

    public void boundMR(){
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate = s->name.startsWith(s);
        System.out.println(predicate.test("Mr.")); // true
        System.out.println(predicate.test("Ms.")); // false
        Predicate<String> preMethodRef = name::startsWith;
        System.out.println(preMethodRef.test("Mr.")); // true
        System.out.println(preMethodRef.test("Ms.")); // false
    }
    public void unboundMR(){
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate = s->s.isEmpty();
        System.out.println(predicate.test("")); // true
        System.out.println(predicate.test("xyz")); // false
        Predicate<String> preMethodRef = String::isEmpty;
        System.out.println(preMethodRef.test("")); // true
        System.out.println(preMethodRef.test("XYZ")); // false

        BiPredicate<String,String> biPredicate = (a,b)->a.startsWith(b);
        biPredicate.test(name,"Mr."); // true
        biPredicate.test(name,"Ms."); // false

        BiPredicate<String,String> biPredicateMethodRef = String::startsWith;
        biPredicateMethodRef.test(name,"Mr."); // true
        biPredicateMethodRef.test(name,"Ms."); // false
    }

    public void constructorMR(){
        // Constructor method reference
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        List<String> list = supplier.get();
        list.forEach(System.out::println);

        Supplier<List<String>> supplierRef = ArrayList::new;
        list = supplierRef.get();
        list.forEach(System.out::println);

        Function<Integer,List<String>> function = (capacity) -> new ArrayList<>(capacity);
        list = function.apply(10);
        list.add("Lambda");
        list.forEach(System.out::println);

        Function<Integer,List<String>> functionRef =  ArrayList::new;
        list = functionRef.apply(10);
        list.add("Lambda");
        list.forEach(System.out::println);

    }
}
