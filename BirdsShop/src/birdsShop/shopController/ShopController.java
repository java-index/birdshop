package birdsShop.shopController;

import birdsShop.domain.Customer;
import birdsShop.domain.Product;
import birdsShop.domain.Shop;
import birdsShop.shopView.SellingViewPanel;
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

    private boolean createTransaction() {
        try {
            ParseFormSellingPanel pf = new ParseFormSellingPanel(shopView.getSellingPanel());
            shop.addTransaction(pf.getCustomer(), (T) pf.getProduct(), pf.getQuantity());
            pf.getProduct().setQuantity(pf.getProduct().getQuantity() - pf.getQuantity());
            shopView.getTransactionPanel().updatePanel();
            shopView.getSellingPanel().repaintPanel(shop);
            return true;
        }
        catch(IllegalArgumentException ex){
            displayMessage("Ups... Check fields");
            shopView.getSellingPanel().getTfUserName().requestFocus();
            return false;
        }
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
                    if(createTransaction()){
                        setTransacionPanelActive();
                    }
                    break;
                case "transactions":
                    setTransacionPanelActive();
                    break;
                case "about":
                    displayMessage("Program \"Shop\"\nby Roman Pyatyntsev\nkademika.com\n2015");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid name of menuItem: " + strCommand);
            }
        }
    }

    private class ParseFormSellingPanel {

        private Customer customer;
        private Product product;
        private double quantity;
        private SellingViewPanel panel;

        public ParseFormSellingPanel (SellingViewPanel panel) throws IllegalArgumentException {
            this.panel = panel;
            customer = parseCustomer();
            product = parseProduct();
            quantity = parseQty();
        }

        private Customer parseCustomer() {
            String nameUser = shopView.getSellingPanel().getTfUserName().getText();
            if(nameUser.length() == 0) throw new IllegalArgumentException();
            return new Customer(nameUser);
        }

        private Product parseProduct(){
            String nameProduct = shopView.getSellingPanel().getRbGroup().getSelection().getActionCommand();
            return shop.getProductByName(nameProduct);
        }

        private double parseQty(){
            String strQuqntity = shopView.getSellingPanel().getTfCount().getText();
            return Double.parseDouble(strQuqntity);
        }

        public Customer getCustomer() {
            return customer;
        }

        public Product getProduct() {
            return product;
        }

        public double getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "" + customer.getNameCustomer() + " " + product.getName() + " " + product.getPrice() + "$ "
                    + this.getQuantity();
        }
    }
}
