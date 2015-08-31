package birdsShop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rabota on 02.08.15.
 */
public class Transaction<T extends Product> {

    static long idSource = 1L;

    private T product;
    private Customer customer;
    private long id;
    private double qty;
    private Date date;

    public Transaction(Customer customer, T product, double qty){
        this.date = new Date();
        this.customer = customer;
        this.product = product;
        this.qty = qty;
        this.id = idSource++;
    };

    public String getFormattedDate(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
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

    public long getId() {
        return id;
    }
}
