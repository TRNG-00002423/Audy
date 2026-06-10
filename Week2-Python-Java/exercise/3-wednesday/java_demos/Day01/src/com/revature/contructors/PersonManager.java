package com.revature.contructors;

public class PersonManager {
  public static void main(String[] args) {
    Person person = new Person("Audy", 27);
    System.out.println(person.displayPerson());

    Person oscar = new Person();
    oscar.setName("Oscar");
    oscar.setAge(28);
    System.out.println("Name :" + oscar.getName());
    System.out.println(oscar.displayPerson());
  }
  
}
