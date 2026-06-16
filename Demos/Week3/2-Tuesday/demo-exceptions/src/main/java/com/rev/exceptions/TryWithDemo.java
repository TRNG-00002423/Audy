package com.rev.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithDemo {

  public static void main(String[] args) {
    FileReader fileReader = null;
    try{
      fileReader = new FileReader("Abc.txt");
    } catch (FileNotFoundException e){
      e.printStackTrace();
    } finally {
      try{
        fileReader.close();
      } catch (IOException e){
        e.printStackTrace();
      }
    }
  }
  
}
