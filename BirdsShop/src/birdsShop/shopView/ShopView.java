package birdsShop.shopView;

import birdsShop.domain.Product;
import birdsShop.domain.Shop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ShopView<T extends Product> extends JFrame {

    public final static String SELLING_PANEL = "selling";
    public final static String TRANSACTION_PANEL = "transaction";

    Shop<T> shop;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    SellingViewPanel sellingPanel;
    TransactionViewPanel transactionPanel;
    JPanel cards;

    public ShopView(Shop<T> shop){
        super("Shop");
        this.shop = shop;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        setLocation(100, 100);
        sellingPanel = new SellingViewPanel(shop);
        transactionPanel = new TransactionViewPanel(shop);
        addComponentToPane(getContentPane());
        setJMenuBar(createMenuBar());
        pack();
        setVisible(true);
    }

    private void addComponentToPane(Container pane) {
        cards = new JPanel(new CardLayout());
        cards.add(sellingPanel, SELLING_PANEL);
        cards.add(transactionPanel, TRANSACTION_PANEL);
        pane.add(cards);
    }

    public void setActivePanel(String namePanel){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, namePanel);
    }

    private JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        menuBar.setBorderPainted(false);

        menu = new JMenu("File");
        addMenuItem("Buy", KeyEvent.VK_1);
        addMenuItem("Quit", KeyEvent.VK_Q);

        menu = new JMenu("View");
        addMenuItem("Transactions", KeyEvent.VK_2);

        menu = new JMenu("?");
        addMenuItem("About", KeyEvent.VK_Q);

        return menuBar;
    }

    private void addMenuItem(String command, int keyEvent){
        menuItem = new JMenuItem(command);
        menuItem.setMnemonic(keyEvent);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(keyEvent, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(command.toLowerCase());
        menu.add(menuItem);
        menuBar.add(menu);
    }

    public void addMenuActionListener(ActionListener menuListener){
        for(int i = 0; i < menuBar.getMenuCount(); i++){
            for(int menuIndex = 0; menuIndex < menuBar.getMenu(i).getItemCount(); menuIndex++){
                JMenuItem menuItem = menuBar.getMenu(i).getItem(menuIndex);
                if(menuItem != null) menuItem.addActionListener(menuListener);
            }
        }
    }

    public void addSellingButtonListener(ActionListener listener){
        sellingPanel.getBtnBuy().addActionListener(listener);
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public SellingViewPanel getSellingPanel(){
        return sellingPanel;
    }

    public TransactionViewPanel getTransactionPanel() {
        return transactionPanel;
    }
}
