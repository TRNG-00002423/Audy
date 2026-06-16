package com.rev.lambdas;

public class MainClass {

  public static void main(String[] args) {
    AdditionImpl additionImpl = new AdditionImpl();
    System.out.println(additionImpl.add(10,20));

    //lambda.       param arrow boddy
    Addition sum = (a,b) -> a+b;
    int result = sum.add(10,20);

    // Lambda -- 3 parts
    // Parameter Arrow Body
    // (a,b) -> a+b;


  }
  
}
