package birdsShop.Birds;

public abstract class Bird {

    private String nameBird;
    private double price;

    public Bird(){};

    public Bird(String nameBird){
        this.nameBird = nameBird;
        price = 5.0;
    }

    public Bird(String nameBird, double price){
        this.nameBird = nameBird;
        this.price = price;
    }

    public String getNameBird() {
        return nameBird;
    }

    public void setNameBird(String nameBird) {
        this.nameBird = nameBird;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
