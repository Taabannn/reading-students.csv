package ir.maktab58.observerq3;

import ir.maktab58.observerq3.service.OnlineShop;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) {
        try {
            OnlineShop onlineShop = new OnlineShop();
            onlineShop.onlineShopSimulation();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
