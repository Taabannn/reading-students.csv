package ir.maktab58.factoryMethodq1.models;

import ir.maktab58.factoryMethodq1.enumeration.AccountType;
import ir.maktab58.factoryMethodq1.exception.IllegalInitialBalanceEx;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class AccountFactory {
    public static Account getAccount(String accountType, long initialBalance,
                                     String ownerName, boolean isInternetBankEnabled,
                                     Date dateOfOpening) {
        Account account;
        if (accountType.equals(AccountType.LONG_TERM.getAccountType())) {
            if (initialBalance < 100000)
                throw new IllegalInitialBalanceEx(accountType + " needs more than 100000 initialBalance", 400);
            account = new LongTermSavingAccount(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
        } else if (accountType.equals(AccountType.SORT_TERM.getAccountType())) {
            if (initialBalance < 50000)
                throw new IllegalInitialBalanceEx(accountType + " needs more than 50000 initialBalance", 400);
            account = new ShortTermSavingAccount(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
        } else if (accountType.equals(AccountType.TRANSACTION.getAccountType())) {
            if (initialBalance < 100000)
                throw new IllegalInitialBalanceEx(accountType + " needs more than 100000 initialBalance", 400);
            account = new TransactionAccount(initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
        } else {
            throw new IllegalStateException("Unexpected value of " + accountType);
        }
        return account;
    }
}
