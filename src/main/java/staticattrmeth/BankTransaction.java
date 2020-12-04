package staticattrmeth;

import java.math.BigDecimal;

public class BankTransaction {
    private static long currentMinValue;
    private static long currentMaxValue;
    private long trxValue;
    private static BigDecimal sumOfTrxs;
    private static long trxcount;

    public BankTransaction(long trxValue) {
        if (trxValue < 1L || trxValue > 10000000L) {
            throw new IllegalArgumentException("¯\\_(ツ)_/¯");
        }
        this.trxValue = trxValue;
        sumOfTrxs = sumOfTrxs.add(new BigDecimal(trxValue));
        trxcount++;
        if (currentMinValue > trxValue || currentMinValue == 0L) {
            currentMinValue = trxValue;
        }
        if (currentMaxValue < trxValue) {
            currentMaxValue = trxValue;
        }
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static void initTheDay() {
        sumOfTrxs = new BigDecimal(0L);
        currentMinValue = 0L;
        currentMaxValue = 0L;
        trxcount = 0L;
    }

    public static BigDecimal averageOfTransaction() {
        return sumOfTrxs.divide(new BigDecimal(trxcount));
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }
}
