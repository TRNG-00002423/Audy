package com.rev.oops;

public class StudentManager {
  public static void main(String[] args) {
  //   Student s1 = new Student();
  //   s1.name = "Audy";
  //   s1.age = 24;
  //   s1.cgpa = 3.8;

  //   Student s2 = new Student();
  //   s2.name = "Utsav";
  //   s2.age = 25;
  //   s2.cgpa = 3.9;

  // }
  // Student s1 = new Student("Audy", 24, 3.8);
  // System.out.println(Student.counter);
  // Student s2 = new Student("John", 26, 3.9);
  // // System.out.println(s1.counter);
  // s2.cgpa = 5;
  // // System.out.println(Student.university);
  // // System.out.println(s1.university);
  // System.out.println(s2.getClass());
  // System.out.println(s2);

  Student s1 = new Student("Cody", 25, 3.9);
  Student s2 = new Student("Cody", 25, 3.9);
  System.out.println(s1==s2);
  s2.enrollCourse("Java");

  }
}
