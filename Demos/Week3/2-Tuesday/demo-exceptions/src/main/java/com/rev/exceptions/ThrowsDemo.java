package com.rev.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsDemo {

  public static void readFile() throws FileNotFoundException{
    FileReader fileReader = new FileReader("abc.txt");
  }

public static void main(String[] args) {
  try{
    readFile(); 
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }
}  
}
