package com.rev.exceptions;

public class ThrowDemo {
  
  public static void checkAge(int age){
    if(age<18){
      throw new IllegalArgumentException(" Access Denied - You must be 18yo");
    }
  }
  public static void main(String[] args) {
    checkAge(10);
  }
}
