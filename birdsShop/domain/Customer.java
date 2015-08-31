package birdsShop.domain;

public class Customer {
    static long idSource = 1L;

    private String nameCustomer;
    private long id;

    public Customer(String nameCustomer){
        this.nameCustomer = nameCustomer;
        this.id = idSource++;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public long getId() {
        return id;
    }
}
