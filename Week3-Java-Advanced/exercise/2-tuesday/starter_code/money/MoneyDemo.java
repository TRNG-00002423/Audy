package money;

import java.util.HashSet;
import java.util.Set;

public class MoneyDemo {
    public static void main(String[] args) {
        // TODO: build Money USD 1000 cents twice, add to HashSet, print size
        Money money1 = new Money("USD", 1000);
        Money money2 = new Money("USD", 1000);

     
        Set<Money> wallet = new HashSet<>();
        wallet.add(money1);
        wallet.add(money2); 

        System.out.println("Wallet size: " + wallet.size());
        
        // TODO: print equals vs ==
        System.out.println("money1.equals(money2): " + money1.equals(money2));
        System.out.println("money1 == money2: " + (money1 == money2));
   
    }
}