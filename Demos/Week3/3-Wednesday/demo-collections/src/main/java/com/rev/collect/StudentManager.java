package com.rev.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {

  public static void main(String[] args) {
    

    Student s1 = new Student(101,"Andrew");
    Student s2 = new Student(102,"Jasdhir");
    Student s3 = new Student(103,"Benson");

    List<Student> students = new ArrayList<>();
    students.add(s1);
    students.add(s2);
    students.add(s3);

    System.out.println(students);
    Collections.sort(students);
    System.out.println(students);

    System.out.println("Sort by name");
    Collections.sort(students, new StudentNameComparator());
    System.out.println(students);
  }
  
}
