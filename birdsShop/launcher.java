package birdsShop;

import birdsShop.Birds.Chicken;

/**
 * Created by rabota on 02.08.15.
 */
public class launcher {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Printer printer = new Printer(shop);

        shop.initDB();
        shop.initTransactions();
        printer.printBirds();
        printer.printTransactions();

    }
}
