package com.rev.fileio;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileExample {

    public static void main(String[] args) {
// (FileInputStream fis = new FileInputStream("example.txt")
        try (FileReader fileReader = new FileReader("example.txt");
             FileWriter fileWriter = new FileWriter("example_write.txt")
            ) {
            System.out.println(System.getProperty("user.dir"));
            int ch;

            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
                fileWriter.write(ch); //writes to new file
            // use the fileOutputStream or FileWriter and write() method
            // call that file as example_write.txt
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}