import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import birdsShop.domain.Customer;
import birdsShop.domain.Product;
import birdsShop.domain.Shop;
import birdsShop.domain.birds.Bird;

import birdsShop.domain.birds.Duck;
import birdsShop.domain.birds.Eagle;
import org.junit.Before;
import org.junit.Test;

public class TestShop {

    Shop<Bird> shop;

    @Before
    public void init(){
        shop = new Shop<>();
    }

    @Test
    public void getProductByNameTest(){
        String name = "Duck";
        assertTrue(shop.getProductByName(name).getName().equals(name));
    }

    @Test(expected = NullPointerException.class)
    public void getExeptionProductByNameTest(){
        String name = "DDDDuck";
        assertTrue(shop.getProductByName(name).getName().equals(name));
    }

    @Test
    public void addTransactionTest(){
        String customerName = "Ivan";
        String productName = "Eagle";
        shop.addTransaction(new Customer(customerName), new Eagle(productName), 100.0);
        assertTrue(shop.getListTransaction().get(0).getCustomer().getNameCustomer().equals(customerName));
        assertTrue(shop.getListTransaction().get(0).getProduct().getName().equals(productName));
    }

    @Test
    public void addProductTest(){
        String productName = "Eagle";
        Duck duck = new Duck(productName);
        shop.addProduct(duck);
        assertEquals("Different name", productName, duck.getName());
    }
}

