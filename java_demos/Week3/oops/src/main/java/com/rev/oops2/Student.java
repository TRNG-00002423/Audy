package com.rev.oops2;

public class Student extends Person implements Loginable{
double cgpa;

public Student(){}

public Student(String name, int age, double cgpa) {
  super(name, age);
  this.cgpa = cgpa;
}

// method overloading
void enrollCourse(String courseName){
  System.out.println(courseName);
}

void enrollCourse(String courseName, int semester){
  System.out.println(courseName + " " + semester);
}

// Polymorphism
@Override
public  void introduce(){
  System.out.println("Hello i am a Student");
}

@Override
public void login(){
  System.out.println();
}
@Override
public void abc(){
  System.out.println();
}
}
