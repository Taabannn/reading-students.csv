package ir.maktab58.factoryMethodq1.models;

import ir.maktab58.factoryMethodq1.enumeration.AccountType;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class ShortTermSavingAccount extends AccountImpl {
    private final static double INTEREST = 0.08;

    public ShortTermSavingAccount(long initialBalance, String ownerName, boolean isInternetBankEnabled, Date dateOfOpening) {
        super(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
    }

    public String calculateInterest() {
        balance += (long) (INTEREST * balance);
        return "interest for account " + accountNumber + " is calculated." +
                "\n" + ownerName + " balance now is: " + balance;
    }

    @Override
    public String getAccountType() {
        return AccountType.SORT_TERM.getAccountType();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Short-Term Saving Account {" + "\n" +
                "balance=" + balance + "\n" +
                ", ownerName='" + ownerName + '\'' + "\n" +
                ", accountNumber=" + accountNumber + "\n" +
                ", isInternetBankEnabled=" + isInternetBankEnabled + "\n" +
                ", creditCardNumber=" + creditCardNumber + "\n" +
                ", dateOfOpening=" + dateOfOpening + "\n" +
                '}';
    }
}
