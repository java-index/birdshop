package birdsShop;

import birdsShop.domain.birds.Bird;

/**
 * Created by rabota on 17.08.15.
 */
public class ItemStoreDB {
    private Bird bird;
    private double price;
    private double qty;

    public ItemStoreDB(Bird bird, double price, double qty){
        this.bird = bird;
        this.price = price;
        this.qty = qty;
    }

    public Bird getBird() {
        return bird;
    }

    public double getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }
}