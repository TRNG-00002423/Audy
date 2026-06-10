package com.revature.methods;

public class DemoMethods {
  
public static void main(String[] args) {
  System.out.println("Sum = " + DemoMethods.sum(2,3));
  System.out.println("Sum = " + sum(2,3,4));

  DemoMethods demoMethods = new DemoMethods();
  System.out.println(demoMethods.sayHello("Audy"));
}
// public static int sum (int num1, int num2) {
//   return (num1+num2);
// }

// public static int sum (int num1, int num2, int num3) {
//   return (num1+num2+num3);
// }

// public static int sum (int num1, int num2, int num3, int num4) {
//   return (num1+num2+num3+num4);
// }

// var args
public static int sum(int ...numbers){
  int total = 0;
  for (int num: numbers)
    total +=num;
  return total;
}

public String sayHello(String name){
  return "Hello" + name;
  
  }
  
}


