package birdsShop;

import birdsShop.Birds.Chicken;

public class launcher {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.initDB();

        ShopUI shopUI = new ShopUI(shop);
        Printer printer = new Printer(shop);

        printer.printTransactions();

    }
}
