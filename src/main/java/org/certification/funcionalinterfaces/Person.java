package org.certification.funcionalinterfaces;

import java.util.Comparator;

class Person {
        private String name;
        private Integer age;
        private Double height;

        public Person(String name, int age, Double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
        public  Double getHeight(){
            return height;
        }


//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", height=" + height +
//                '}';
//    }
}
