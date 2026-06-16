package com.rev.exceptions;

public class UnCheckedDemo {
    public static void main(String[] args) {
        int [] myArray = new int[5];
        try{
            myArray[5] = 10;
            System.out.println(myArray[5]);
        // } catch (ArrayIndexOutOfBoundsException e) {
        //     e.printStackTrace();
        // } catch (Exception e){
        //     e.printStackTrace();
        } catch ( ArrayIndexOutOfBoundsException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Program Ends .....");
        }
    }
}