package org.certification.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        List<Double> temps = Arrays.asList(98.4, 100.2, 101.3, 97.9);
//        System.out.println("Number of temps >100 is: " + temps.stream().filter(t -> t > 100).peek(System.out::println).count());

//            Map<String, Integer> map = new HashMap<>();
//            map.put("a",1);
//            map.put("a",2);
//            map.put("b",1);
//            map.put("c",1);
//            map.put("d",1);
//            Set<Map.Entry<String,Integer>> set = map.entrySet().stream().collect(Collectors.toSet());
//            System.out.println("Numbers of entries: " + set.add(Map.entry("test",2)));
//
//        Optional<String> min  = Stream.of("bear","horse","deer",null).filter(Objects::nonNull).min(Comparator.comparingInt(String::length));
//
//        min.ifPresent(System.out::println);


//        StringBuilder word = Stream.of("add","egg","cat").collect(StringBuilder::new,StringBuilder::append,(sb1, sb2)->sb1.append(sb2));
//        System.out.println(word);

        TreeMap<String, Integer> map = Stream.of("cake","apple","banana","tart","cake").collect(Collectors.toMap(s->s,
                String::length,
                Integer::sum,
                TreeMap::new));
        System.out.println(map);
    }
}
