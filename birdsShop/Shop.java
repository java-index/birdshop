package birdsShop;

import birdsShop.Birds.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {

    private Transaction transaction;
    private Customer customer;
    private Bird bird;
    private ItemStoreDB itemStore;

    private List<Transaction> listTransactions;
    private List<Customer> listCustomers;
    private List<Bird> listBirds;
    private List<ItemStoreDB> listStoreDB;

    public Shop(){
        listTransactions = new ArrayList<>();
        listCustomers = new ArrayList<>();
        listBirds = new ArrayList<>();
        listStoreDB = new ArrayList<>();
    }

    /* getters */

    public List<Bird> getListBirds() {
        return listBirds;
    }

    public List<Customer> getListCustomer() {
        return listCustomers;
    }

    public List<Transaction> getListTransaction() {
        return listTransactions;
    }

    /* setteres */

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /* added */

    public void addBird(Bird bird){
        listBirds.add(bird);
    }

    public void addCustomer(Customer customer){
        listCustomers.add(customer);
    }

    public void addTransaction(Customer customer, Bird bird, double qty){
        listTransactions.add(new Transaction(customer, bird, qty));
    }

    public void addToStoreDB(Bird bird, double price, double qty, Category category){
        listStoreDB.add(new ItemStoreDB(bird, price, qty, category));
    }

    public void initDB(){
        addBird(new Chicken());
        addBird(new Duck());
        addBird(new Eagle());
        addBird(new Turkey());

        addCustomer(new Customer("Petrov"));
        addCustomer(new Customer("Ivanov"));
        addCustomer(new Customer("Sidorov"));

        for(int i = 0; i < listBirds.size(); i++){
            addToStoreDB(listBirds.get(i), (listBirds.get(i)).getPrice(), 1000.0, Category.NONE);
        }
    }

    public void initTransactions(){
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            int randCustomer = rand.nextInt(listCustomers.size());
            int randDBird = rand.nextInt(listBirds.size());
            addTransaction(listCustomers.get(randCustomer), listBirds.get(randDBird), rand.next(100.0));
        }
    }

    private class ItemStoreDB {
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
    }
}
