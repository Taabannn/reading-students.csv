package ir.maktab58.factoryMethodq1.models;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * @author Taban Soleymani
 */
public abstract class AccountImpl implements Account{
    protected long balance;
    protected String ownerName;
    protected long accountNumber;
    protected boolean isInternetBankEnabled;
    protected int creditCardNumber;
    protected Date dateOfOpening;

    public AccountImpl(long initialBalance, String ownerName, boolean isInternetBankEnabled, Date dateOfOpening) {
        this.balance = initialBalance;
        this.ownerName = ownerName;
        this.isInternetBankEnabled = isInternetBankEnabled;
        this.dateOfOpening = dateOfOpening;
        Random random = new Random();
        this.accountNumber = Math.abs(random.nextLong());
        this.creditCardNumber = Math.abs(random.nextInt());
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isInternetBankEnabled() {
        return isInternetBankEnabled;
    }

    public void setInternetBankEnabled(boolean internetBankEnabled) {
        isInternetBankEnabled = internetBankEnabled;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(Date dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountImpl account = (AccountImpl) o;
        return accountNumber == account.accountNumber && creditCardNumber == account.creditCardNumber && ownerName.equals(account.ownerName) && dateOfOpening.equals(account.dateOfOpening);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, accountNumber, creditCardNumber, dateOfOpening);
    }

    @Override
    public String toString() {
        return "AccountImpl{" +
                "balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                ", accountNumber=" + accountNumber +
                ", isInternetBankEnabled=" + isInternetBankEnabled +
                ", creditCardNumber=" + creditCardNumber +
                ", dateOfOpening=" + dateOfOpening +
                '}';
    }
}
