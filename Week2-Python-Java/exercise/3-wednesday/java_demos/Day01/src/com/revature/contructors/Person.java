package com.revature.contructors;

public class Person {
  private String name;
  private int age;


  public Person(){

  } 

  public Person (String name,int age){
    this.name = name;
    this.age = age;
  }

  public String displayPerson(){
    return "Name: " + this.name + ", Age :" + this.age;

  }
  public int getAge() {
    return age;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

}