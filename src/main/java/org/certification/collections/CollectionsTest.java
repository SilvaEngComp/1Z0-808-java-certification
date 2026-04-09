package org.certification.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CollectionsTest {
    public static void main(String[] args) {

        arrayList();
        separator();
        stack();
        separator();
        linkedList();
    }
    public static void separator(){
        System.out.println("------------------------------------------------------------------------");
    }

    private static void arrayList() {
       List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");
        System.out.println("full list"+list);
        System.out.println("element 1: "+list.get(1));
        list.remove(0);
        System.out.println("zero removed"+list);
        list.removeIf(name->name.startsWith("A"));
        System.out.println("name with A removed"+list);
        list.set(0,"Jack");
        System.out.println("element 0 set to Jack"+list);
        list.replaceAll(String::toUpperCase);
        System.out.println("all names to upper case"+list);
    }

    private static void stack(){
        Stack<String> stack = new Stack<>();
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println("stack: "+stack);
        System.out.println("peek: "+stack.peek());
        System.out.println("pop: "+stack.pop());
        System.out.println("stack: "+stack);
        stack.push("Diana");
        System.out.println("Diana has pushed: "+stack);
    }

    private static void linkedList() {
        // LinkedList is a doubly-linked list implementation of the List and Deque interfaces.
        // It allows for efficient insertion and removal of elements at both ends of the list.
        // LinkedList also provides methods for accessing elements at specific positions in the list.
        LinkedList<String> names = new LinkedList<>();
        names.add("Colia");
        names.add("Diana");
        names.add("Elena");
        System.out.println("LinkedList: "+names);
         names.addFirst("Barbara");
        System.out.println("LinkedList: "+names);
        names.addLast("David");
        System.out.println("LinkedList: "+names);

        names.remove("Elena");
        System.out.println("Elena Removed: "+names);
        names.removeFirst();
        System.out.println("First element removed: "+names);
        names.removeLast();
        System.out.println("Last element removed: "+names);
    }
}
