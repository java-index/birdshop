package birdsShop;

import birdsShop.Birds.Bird;
import java.util.Date;

/**
 * Created by rabota on 02.08.15.
 */
public class Transaction {
    private Bird bird;
    private Customer customer;
    private Category category;

    private double qty;
    private Date date;

    public Transaction(){
        this.date = new Date();
    };

    public Transaction(Customer customer, Bird bird, double qty, Category category){
        this();
        this.customer = customer;
        this.bird = bird;
        this.qty = qty;
        this.category = category;
    };

    public Date getDate() {
        return date;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
