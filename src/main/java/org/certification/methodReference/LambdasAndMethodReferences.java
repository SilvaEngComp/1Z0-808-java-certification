package org.certification.methodReference;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {

    }

    public static void staticMR(){
        List<Integer> list = List.of(1,2,7,4,5);
        Consumer<List<Integer>> sort1 = l-> Collections.sort(l);
        sort1.accept(list);
        list.forEach(System.out::println);
        list = List.of(1,2,7,4,5);
        Consumer<List<Integer>> sort = Collections::sort;
        sort.accept(list);
        list.forEach(System.out::println);
    }
}
