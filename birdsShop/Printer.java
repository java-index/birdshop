package birdsShop;

import birdsShop.Birds.Bird;

import java.util.Date;

public class Printer {
    private Shop shop;

    public Printer(Shop shop){
        this.shop = shop;
    }

    public void printBirds(){
        for(Bird b: shop.getListBirds()){
            System.out.println(b.getNameBird());
        }
    }

    public void printTransactions(){
        for(Transaction t : shop.getListTransaction()){
            //Date date;
            String nameCustomer = t.getCustomer().getNameCustomer();
            String nameBird = t.getBird().getNameBird();
            double qty = t.getQty();
            double price = t.getBird().getPrice();
            System.out.println(nameCustomer + ", " + nameBird + ", category: " t.+ price: " + price + "$, qty: "+ qty);
        }
    }

}
