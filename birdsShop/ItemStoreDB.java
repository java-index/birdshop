package birdsShop;

import birdsShop.Birds.Bird;

/**
 * Created by rabota on 17.08.15.
 */
public class ItemStoreDB {
    private Bird bird;
    private double price;
    private double qty;
    private Category category;

    public ItemStoreDB(Bird bird, double price, double qty, Category category){
        this.bird = bird;
        this.price = price;
        this.qty = qty;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }
}