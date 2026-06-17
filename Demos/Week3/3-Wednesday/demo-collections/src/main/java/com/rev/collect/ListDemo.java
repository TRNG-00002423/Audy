package com.rev.collect;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();

        arrayList.add("Apple");
        arrayList.add("Banana");

        arrayList.add(1, "Pineapple");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Red"); 
        linkedList.add("Blue"); 
        linkedList.addFirst("Green"); 
        linkedList.addLast("Aqua");

        // enhanced for loop
        System.out.println("Original List:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // get(int index)
        System.out.println("\nElement at index 1: " + arrayList.get(1));

        // set(int index, E element)
        arrayList.set(2, "Orange");
        System.out.println("\nAfter set():");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // remove(int index)
        arrayList.remove(0);
        System.out.println("\nAfter remove():");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // indexOf(Object o)
        System.out.println("\nIndex of Orange: " + arrayList.indexOf("Orange"));

        // subList(int fromIndex, int toIndex)
        List<String> subList = arrayList.subList(0, 2);
        System.out.println("\nSubList:");
        for (String fruit : subList) {
            System.out.println(fruit);
        }

        // size()
        System.out.println("\nSize: " + arrayList.size());

        // contains()
        System.out.println("Contains Orange? " + arrayList.contains("Orange"));

        // containsAll()
        List<String> checkList = new ArrayList<>();
        checkList.add("Pineapple");
        checkList.add("Orange");

        System.out.println("Contains all elements in checkList? "
                + arrayList.containsAll(checkList));

        // addAll()
        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("Mango");
        moreFruits.add("Grapes");

        arrayList.addAll(moreFruits);

        System.out.println("\nAfter addAll():");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }
    }
}