package com.rev.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedDemo {
  public static void main(String[] args) {
    
    try {
      FileReader FileReader = new FileReader("abc.txt");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
}
