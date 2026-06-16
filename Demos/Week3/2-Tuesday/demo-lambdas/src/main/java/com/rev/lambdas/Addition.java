package com.rev.lambdas;

public interface Addition {
  int add(int a, int b);
  // int sum(int a, int b);
  default void printInfo(){ // method w a body 
    System.out.println("Default methods ....");
  }

  static void printStatic(){}
}

// Serializable, Clonable, Remote