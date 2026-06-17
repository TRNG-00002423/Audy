package banking;
import java.util.HashMap;

public class Bank {
    // TODO HashMap<String, Account>
    private HashMap<String, Account> accounts = new HashMap<>();

    public void openAccount(String id, double initialDeposit) throws InvalidAccountException {
         if (id == null || id.isBlank()) {
            throw new InvalidAccountException("Account id cannot be blank");
        }
        if (accounts.containsKey(id)) {
            throw new InvalidAccountException("Account already exists: " + id);
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        accounts.put(id, new Account(id, initialDeposit));
    }

    public Account getAccount(String id) throws InvalidAccountException {
        Account account = accounts.get(id);
        if (account == null) {
            throw new InvalidAccountException("No such account: " + id);
        }
        return account;
    }

    public void transfer(String fromId, String toId, double amount)
            throws InvalidAccountException, InsufficientFundsException {
        Account from = getAccount(fromId);
        Account to = getAccount(toId);
 
        from.withdraw(amount); 
        to.deposit(amount);
    }
}
