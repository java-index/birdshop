package birdsShop.shopController;

import birdsShop.domain.Product;
import birdsShop.domain.Shop;
import birdsShop.shopView.ShopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopController<T extends Product> {

    private Shop<T> shop;
    private ShopView shopView;

    public ShopController(Shop<T> shop,  ShopView shopView){
        this.shop = shop;
        this.shopView = shopView;
        addListenerToView();
    }

    private final void addListenerToView(){
        MyListener myListener = new MyListener();
        shopView.addMenuActionListener(myListener);
        shopView.addSellingButtonListener(myListener);
    }

    private void displayMessage(String message){
        shopView.displayMessage(message);
    }

    private void createTransaction() {

    }
    private void setSellingPanelActive(){
        shopView.setActivePanel(shopView.SELLING_PANEL);
    }

    private void setTransacionPanelActive(){
        shopView.setActivePanel(shopView.TRANSACTION_PANEL);
    }

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String strCommand = e.getActionCommand();
            switch (strCommand){
                case "quit":
                    System.exit(0);
                case "buy":
                    setSellingPanelActive();
                    break;
                case "btn_buy":
                    createTransaction();
                    break;
                case "about":
                    displayMessage("Program \"Shop\"\nby Roman Pyatyntsev\nkademika.com\n2015");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid name of menuItem: " + strCommand);
            }
        }
    }
}
