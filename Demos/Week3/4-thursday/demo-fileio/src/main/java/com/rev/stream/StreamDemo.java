package com.rev.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rev.fileio.Student;

public class StreamDemo {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Cody", "Dwight","Audy","Curtis");
    // disokays names that start with "A"
    List<String> namesA = new ArrayList<>();
    for(String name:names){
      if(name.startsWith("A"))
        namesA.add(name);
    }
    List<String> result = names.stream()
                              .filter(name->name.startsWith("A"))
                              .collect(Collectors.toList());
    
    List<String> upperName = names.stream()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());             
    
  
  
  
    System.out.println(upperName);

    List<String> sorted = names.stream()
                          .sorted()
                          .collect(Collectors.toList());

    System.out.println(sorted);
  
    names.stream()
        .forEach(System.out::println);
    
    List<String> upperCase_C = names.stream()
                              .filter(name->name.startsWith("C"))
                              .map(String::toUpperCase)
                              .sorted()
                              .collect(Collectors.toList());

    // reduce() to get longest string
    Optional<String> longestString = names.stream()
                                    .reduce((a, b) -> a.length() > b.length() ? a : b);

    System.out.println("Longest string: " + longestString);
      
    // Optional Class
    
    // Optional class is used to check for null pointer
    // Student student = null;
    // if (student!=null)
    //   student.someMethod();
    // else
    //   System.out.println("Some Code");
    
  }
  
}
