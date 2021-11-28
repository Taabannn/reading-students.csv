package ir.maktab58.factoryMethodq1;

import ir.maktab58.factoryMethodq1.service.BankService;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        bankService.addCustomerThread("short-term saving account", 60000, "Ali Hosseini", true, new Date(121, 10, 21));
        bankService.addCustomerThread("transaction account", 1000000, "Mohammad Mohammadi", true, new Date(121, 10, 21));
        bankService.enableCustomerThreads();
    }
}
