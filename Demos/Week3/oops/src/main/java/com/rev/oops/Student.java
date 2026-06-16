package com.rev.oops;

import java.util.Objects;

public class Student {
  String name;
  int age;
  double cgpa;

  static String university = "ABC University";
  static int counter=0;
  public Student(){}

  public Student(String name, int age, double cgpa){
    this.name = name;
    this.age = age;
    this.cgpa = cgpa;
    counter++;
  }

  // encapsulation getter setters - accessed in a controlled manner
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getCgpa() {
    return cgpa;
  }

  public void setCgpa(double cgpa) {
    if (cgpa >=0 && cgpa <=4.0){
    this.cgpa = cgpa;
    }
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", cgpa=" + cgpa + "]";
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    Student other = (Student) obj;
    return age == other.age && Double.compare(cgpa, other.cgpa) == 0 && name.equals(other.name);
  }

  // returns hash of two objects
  @Override
  public int hashCode() {
    return Objects.hash(name,age,cgpa);
  }

  public void enrollCourse(String courseName){
    // complex code
    System.out.println("Enrolled in : " + courseName);
  }
  




}
