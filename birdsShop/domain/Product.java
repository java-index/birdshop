package birdsShop.domain;

public abstract class Product {

    private static long idSource = 1L;

    private String name;
    private double price;
    private long quantity;
    private long id;

    public Product(){
        this.id = idSource++;
        this.name = "no name";
        this.price = 0.0;
        this.quantity = 0;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

