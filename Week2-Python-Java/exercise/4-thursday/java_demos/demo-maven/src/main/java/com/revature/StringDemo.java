package com.revature;

public class StringDemo {
  public static void main(String[] args) {
    
    String s1 = "Hello";
    String s2 = new String("Hello");

    String s11 = s1.concat("World");
    System.out.println(s11);
    System.out.println(s11.length());
    System.out.println(s11.charAt(7));

    s1.equalsIgnoreCase(s2);

    s1.toUpperCase();
    s1.trim();

    s1.replace("e", "a");
    s1.contains("11");

    StringBuffer sBuffer = new StringBuffer("Hello");
    sBuffer.insert(2,"abcd");
    System.out.println(sBuffer);
    sBuffer.replace(0,0, s11);
  }
  
}
