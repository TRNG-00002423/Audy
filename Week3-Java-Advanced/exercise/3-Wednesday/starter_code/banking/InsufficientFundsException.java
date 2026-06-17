package banking;

/** Checked — include shortfall. */
public class InsufficientFundsException extends Exception {
    private double shortFall;

    public InsufficientFundsException(double shortFall){
        super("Withdrawal failed! You are short by: " + shortFall);
        this.shortFall = shortFall;
    }

    public double getShortFall(){
        return shortFall;
    }
}
