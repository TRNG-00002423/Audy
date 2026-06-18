package money;

import java.util.Objects;

/**
 * TODO: immutable currency + amountMinor; equals/hashCode contract.
 */
public final class Money {
    // TODO fields, constructor validates currency non-null
    private String currency;
    private long amountMinor;

    
    // TODO getters

    public Money(String currency, long amountMinor) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        this.currency = currency;
        this.amountMinor = amountMinor;
    }


    public String getCurrency() {
        return this.currency;
    }


    public long getAmountMinor() {
        return this.amountMinor;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o){
        return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Money other = (Money) o;
        return amountMinor == other.amountMinor && Objects.equals(currency, other.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.amountMinor);
    }

    @Override
    public String toString() {
        return this.currency + " " + this.amountMinor;

    }
}
