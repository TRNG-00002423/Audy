/**
 * Week 2 Exercise — Calculator with static methods and overloads.
 *
 * Division by zero strategy (TODO — choose and implement):
 *   Option A: print error message and return Double.NaN
 *   Option B: return 0.0 and document why (not ideal for production)
 *
 * Compile: javac Calculator.java
 * Run:     java Calculator
 */
public class Calculator {
    /**
     * Adds two doubles together
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /** Sum of three doubles — overloads add(a,b). 
     * 
     * @param a the first number
     * @param b the second number
     * @param c the third number
     * @return the sum of (a+b) and c
    */
    public static double add(double a, double b, double c) {
        return (a+b) + c;
    }

     /**
     * Subtracts two doubles together
     *
     * @param a the first number
     * @param b the second number
     * @return the result of a and b
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

     /**
     * Multiplies two doubles together
     *
     * @param a the first number
     * @param b the second number 
     * @return the result of a and b
     */
    public static double multiply(double a, double b) {
        return a*b;
    }

     /**
     * Divides two doubles together
     *
     * @param a the first number
     * @param b the second number (if b == 0) implement DivisionByZero Error then  return Double.NaN
     * @return the result of a and b
     */
    public static double divide(double a, double b) {
        if(b == 0){
            System.out.println("Error: Division by Zero");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        // TODO: demonstrate all methods including overload and divide-by-zero
        System.out.println(add(2.0, 4.0)); // 6.0
        System.out.println(add(1.0, 2.0, 3.0)); // 6.0
        System.out.println(subtract(10.0, 4.0)); // 6.0
        System.out.println(multiply(3.0, 5.0)); // 15.0
        System.out.println(divide(10.0, 2.0)); // 5.0
        System.out.println(divide(10.0, 0)); // Error returns NaN
    }
}
