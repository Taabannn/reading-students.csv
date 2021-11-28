package ir.maktab58.factoryMethodq1.models;

import ir.maktab58.factoryMethodq1.enumeration.AccountType;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class LongTermSavingAccount extends AccountImpl {
    public LongTermSavingAccount(long initialBalance, String ownerName, boolean isInternetBankEnabled, Date dateOfOpening) {
        super(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
    }

    @Override
    public String getAccountType() {
        return AccountType.LONG_TERM.getAccountType();
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
        return "Long-Term Saving Account {" + "\n" +
                "balance=" + balance + "\n" +
                ", ownerName='" + ownerName + '\'' + "\n" +
                ", accountNumber=" + accountNumber + "\n" +
                ", isInternetBankEnabled=" + isInternetBankEnabled + "\n" +
                ", creditCardNumber=" + creditCardNumber + "\n" +
                ", dateOfOpening=" + dateOfOpening + "\n" +
                '}';
    }
}
