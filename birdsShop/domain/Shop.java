package birdsShop.domain;

import birdsShop.BirdCategory;
import birdsShop.domain.birds.*;
import java.util.ArrayList;
import java.util.List;

public class Shop<T extends Product> {

    private Transaction transaction;
    private Customer customer;
    private T product;

    private List<Transaction> listTransactions;
    private List<Customer> listCustomers;
    private List<T> listProduct;

    public Shop(){
        listTransactions = new ArrayList<>();
        listCustomers = new ArrayList<>();
        listProduct = new ArrayList<>();
        initShopStore();
    }

    public List<T> getListProduct() {
        return listProduct;
    }

    public List<Customer> getListCustomer() {
        return listCustomers;
    }

    public List<Transaction> getListTransaction() {
        return listTransactions;
    }

    public T getProductByName(String nameProduct){
        for(T product : listProduct){
            if (nameProduct.equals(product.getName())) return product;
        }
        return null;
    }

    public void addProduct(T product){
        listProduct.add(product);
    }

    public void addCustomer(Customer customer){
        listCustomers.add(customer);
    }

    public void addTransaction(Customer customer, T product, double qty){
        listTransactions.add(new Transaction(customer, product, qty));
    }

    /* initialize Shop */

    private void initShopStore(){
        Bird chicken = new Chicken("Chicken");
        Bird eagle = new Eagle("Eagle");
        Bird duck = new Duck("Duck");
        Bird turkey = new Turkey("Turkey");
        initProduct(chicken, 45.0, 100, BirdCategory.Domestic);
        initProduct(eagle, 98, 355, BirdCategory.Wild);
        initProduct(duck, 15.0, 655, BirdCategory.Domestic);
        initProduct(turkey, 66.0, 456, BirdCategory.Decorative);

    }

    private void initProduct(Bird bird, double price, long qty, BirdCategory category){
        bird.setPrice(price);
        bird.setQuantity(qty);
        bird.setCategory(category);
        addProduct((T)bird);
    }
}
