package birdsShop;

import birdsShop.domain.Shop;
import birdsShop.domain.birds.*;
import birdsShop.shopController.ShopController;
import birdsShop.shopView.ShopView;

public class launcher {
    public static void main(String[] args) {
        Shop<Bird> shop = new Shop<>();
        ShopView<Bird> shopView = new ShopView<>(shop);
        ShopController<Bird> shopController = new ShopController<>(shop, shopView);
    }
}
