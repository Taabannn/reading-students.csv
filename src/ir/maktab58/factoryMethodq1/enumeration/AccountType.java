package ir.maktab58.factoryMethodq1.enumeration;

/**
 * @author Taban Soleymani
 */
public enum AccountType {
    SORT_TERM("short-term saving account"),
    LONG_TERM("long-term saving account"),
    TRANSACTION("transaction account");

    private final String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
