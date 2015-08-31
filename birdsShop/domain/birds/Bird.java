package birdsShop.domain.birds;

import birdsShop.BirdCategory;
import birdsShop.domain.Product;

public abstract class Bird extends Product {

    private BirdCategory category;

    public Bird(){}

    public Bird (String name){
        this.setName(name);
    }

    public BirdCategory getCategory() {
        return category;
    }

    public void setCategory(BirdCategory category) {
        this.category = category;
    }

    public String getCategoryName(){
        return category.name();
    }
}
