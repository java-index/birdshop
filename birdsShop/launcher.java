package birdsShop;

import birdsShop.domain.Shop;
import birdsShop.domain.birds.*;
import birdsShop.domain.Product;
import birdsShop.shopController.ShopController;
import birdsShop.shopView.ShopView;

public class launcher {
    public static void main(String[] args) {
        Shop<Bird> shop = new Shop<Bird>();
        ShopView<Bird> shopView = new ShopView<>(shop);
        ShopController<Bird> shopController = new ShopController<>(shop, shopView);

//        Printer printer = new Printer(shop);
//
//        printer.printTransactions();
//        Product eagle = new Eagle("Eagle-1");
//        Product chicken = new Chicken("Chicken-1");
//        Product duck = new Duck("Duck-1");
//        duck.setPrice(45.0);
//        System.out.printf("%s %-10s %4s\n", eagle.getId(), eagle.getName(), eagle.getPrice());
//        System.out.printf("%s %-10s %4s\n", chicken.getId(), chicken.getName(), chicken.getPrice());
//        System.out.printf("%s %-10s %4s\n", duck.getId(), duck.getName(), duck.getPrice());
    }
}
