package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private long balance;
    private static final List<Rate> RATES = new ArrayList<>();

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public CreditCard(long balance, Currency currency) {
        this(balance);
    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        RATES.addAll(rates);
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        long value = Math.round(amount * getConversionRate(currency));
        if (value <= balance) {
            balance -= value;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    private double getConversionRate(Currency currency) {
        for (Rate rate : RATES) {
            if (rate.getCurrency() == currency) {
                return rate.getConversionFactor();
            }
        }
        return 1.0;
    }
}
