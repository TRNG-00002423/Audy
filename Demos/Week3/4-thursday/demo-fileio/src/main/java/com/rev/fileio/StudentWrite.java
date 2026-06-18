package com.rev.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentWrite {

  public static void main(String[] args) {
    Student s = new Student(101, "audy", 24);
    try(
      FileOutputStream fos = new FileOutputStream("student.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos)
    ){
      
      oos.writeObject(s);
      System.out.println("Object Written to a file");
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
}

// Read the student.dat file and create that student object
// FileinputStream and ObjectINput Stream
