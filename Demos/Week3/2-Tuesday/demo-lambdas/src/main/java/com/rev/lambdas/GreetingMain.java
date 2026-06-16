package com.rev.lambdas;

public class GreetingMain {
  public static void main(String[] args) {
    // lambda multi-lines
    // Greeting greet=name-> {
    //   String nameCaps=name.toUpperCase();
    //   return "Greetings " +nameCaps;
    // };
    // lambda single line
    Greeting greet =(name)-> "Greetings " + name.toUpperCase();
    System.out.println(greet.sayHello("Audy"));
  }
}
