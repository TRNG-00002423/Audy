package com.rev.oops2;

public class Professor extends Person{
  double salary;

  public Professor() {}

  public Professor(String name, int age, double salary) {
    super(name, age);
    this.salary = salary;
  }

  
  // Polymorphism
  @Override
  public  void introduce(){
    System.out.println("Hello i am a Professor");
  }


  
}
