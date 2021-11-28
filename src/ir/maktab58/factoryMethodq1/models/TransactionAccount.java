package ir.maktab58.factoryMethodq1.models;

import ir.maktab58.factoryMethodq1.enumeration.AccountType;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class TransactionAccount extends AccountImpl {
    boolean isChequebookEnabled;

    public TransactionAccount(long initialBalance, String ownerName, boolean isInternetBankEnabled, Date dateOfOpening) {
        super(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
    }

    public boolean isChequebookEnabled() {
        return isChequebookEnabled;
    }

    public void setChequebookEnabled(boolean chequebookEnabled) {
        isChequebookEnabled = chequebookEnabled;
    }

    public String enableChequebook() {
        isChequebookEnabled = true;
        return "cheque book is enabled for account " + accountNumber;
    }

    @Override
    public String getAccountType() {
        return AccountType.TRANSACTION.getAccountType();
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
        return "Transaction Account {" + "\n" +
                "balance=" + balance + "\n" +
                ", ownerName='" + ownerName + '\'' + "\n" +
                ", accountNumber=" + accountNumber + "\n" +
                ", isInternetBankEnabled=" + isInternetBankEnabled + "\n" +
                ", creditCardNumber=" + creditCardNumber + "\n" +
                ", dateOfOpening=" + dateOfOpening + "\n" +
                ", isChequebookEnabled=" + isChequebookEnabled + "\n" +
                '}';
    }
}
