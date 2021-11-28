package ir.maktab58.factoryMethodq1.exception;

/**
 * @author Taban Soleymani
 */
public class IllegalInitialBalanceEx extends RuntimeException {
    int errorCode;

    public IllegalInitialBalanceEx(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
