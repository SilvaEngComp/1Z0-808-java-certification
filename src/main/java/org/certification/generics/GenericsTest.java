package org.certification.generics;

import java.util.List;

public class GenericsTest {

    public static void main(String[] args) {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat(), new Cat());
        standard(dogs);
    }

    public static void standard(List<?> list){
        for(Object obj : list){
            ((Dog) obj).eat();
        }
    }
    public static void extend(List<? extends Animal> list){
        for(Animal obj : list){
            ((Dog) obj).eat();
        }
    }

    public static class Animal{
        public void eat(){
            System.out.println("Animal is eating");
        }
    }

    public static class Dog extends Animal{
        @Override
        public void eat(){
            System.out.println("Dog is eating");
        }
    }

    public static class Cat extends Animal{
        @Override
        public void eat(){
            System.out.println("Cat is eating");
        }
    }
}
