package com.rev.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add("Java");
        list.add("Kotlin");
        list.add("Maven");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        for (String element : list) {
            System.out.println(element);
        }
    }
}