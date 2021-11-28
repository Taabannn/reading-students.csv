package ir.maktab58.factoryMethodq1.service;

import ir.maktab58.factoryMethodq1.models.Account;
import ir.maktab58.factoryMethodq1.models.AccountFactory;
import ir.maktab58.factoryMethodq1.models.ShortTermSavingAccount;
import ir.maktab58.factoryMethodq1.models.TransactionAccount;

import java.util.*;

/**
 * @author Taban Soleymani
 */
public class BankService {
    List<Thread> customerThreads = new ArrayList<>();

    public void addCustomerThread(String accountType, long initialBalance, String ownerName, boolean isInternetBankEnabled, Date dateOfOpening) {
        Thread thread = new Thread(() -> {
            Account account = AccountFactory.getAccount(accountType, initialBalance, ownerName, isInternetBankEnabled, dateOfOpening);
            System.out.println(account + " is created successfully.");
            Random random = new Random();
            Thread.currentThread().setName("Thread" + (random.nextInt(10)));
            try {
                enableInterestForSTAccount(account);
                getChequeBook(account);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        customerThreads.add(thread);
    }

    private void getChequeBook(Account account) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        if (account instanceof TransactionAccount) {
            System.out.println("In " + Thread.currentThread().getName() + ", Would you like to get cheque book?");
            String answer = scanner.nextLine().trim();
            if (answer.equals("Yes")) {
                TransactionAccount transactionAccount = (TransactionAccount) account;
                System.out.println(transactionAccount.enableChequebook());
            }
        }
    }

    private void enableInterestForSTAccount(Account account) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        if (account instanceof ShortTermSavingAccount) {
            System.out.println("In " + Thread.currentThread().getName() + ", Would you like to enable interest?");
            String answer = scanner.nextLine().trim();
            if (answer.equals("Yes")) {
                ShortTermSavingAccount shortTermSavingAccount = (ShortTermSavingAccount) account;
                System.out.println(shortTermSavingAccount.calculateInterest());
            }
        }
    }

    public void enableCustomerThreads() {
        customerThreads.forEach(Thread::start);
    }
}
