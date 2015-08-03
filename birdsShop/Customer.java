package birdsShop;

public class Customer {
    private String nameCustomer;

    public Customer(){};

    public Customer(String nameCustomer){
        this.nameCustomer = nameCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
}
