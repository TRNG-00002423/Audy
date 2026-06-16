package com.rev.oops2;

public class CollegeManager {
  public static void main(String[] args) {
    // Person person = new Person();
    Student student = new Student();
    Professor professor = new Professor();

    Student [] students = new Student[5];

    students[0] = new Student();
    students[1] = new Student();

    // Student s = new Student();
    // // upcasting == typecasting
    // Person p=s;
    Person p = new Student();
    Student s=(Student) p;



  }
  
}
