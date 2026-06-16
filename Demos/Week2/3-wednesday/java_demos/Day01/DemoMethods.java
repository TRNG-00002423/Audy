import java.util.Scanner;

public class DemoMethods {
  public static void main(String[] args) {
    System.out.println("Hello VS Code...");
    // lets call the function
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    // call or invoke the method
    String result = greet(name);
    System.out.println(result);

  }

  static String greet(String name){
    return "Hello " + name;
  }

}