package banking;

public class BankingDemo {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        bank.openAccount("audy", 100.0);
        bank.openAccount("emily", 50.0);
 
        // TODO: demonstrates success path + catch InsufficientFundsException + InvalidAccountException
        try {
            bank.transfer("audy", "emily", 30.0);
            System.out.println("Transfer succeeded: audy -> emily $30.00");
 
            bank.transfer("audy", "emily", 1000.0); // not enough funds, should throw
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        }
 
        // trigger InvalidAccountException directly
        try {
            bank.getAccount("aly");
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        }
 
        // trigger IllegalArgumentException on bad deposit
        try {
            bank.getAccount("emily").deposit(-25.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }
}
