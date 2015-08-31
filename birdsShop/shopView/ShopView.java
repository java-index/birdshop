package birdsShop.shopView;

import birdsShop.domain.Product;
import birdsShop.domain.Shop;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class ShopView<T extends Product> extends JFrame {

    public final static String SELLING_PANEL = "selling";
    public final static String TEST_PANEL = "test";
    public final static String TRANSACTION_PANEL = "transaction";

    Shop<T> shop;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    JButton btnBye;
    JPanel sellingPanel;
    JPanel test;
    JPanel transactionPanel;
    JPanel cards;

    public ShopView(Shop<T> shop){
        super("Shop");
        this.shop = shop;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        setLocation(100, 100);
        addComponentToPane(getContentPane());
        setJMenuBar(createMenuBar());
        pack();
        setVisible(true);
    }

    public void addComponentToPane(Container pane) {

        JPanel card2 = new JPanel();
        card2.add(new JButton("Button 1"));

        JPanel card1 = createSellingPanel();

        cards = new JPanel(new CardLayout());
        cards.add(card1, SELLING_PANEL);
        cards.add(card2, TEST_PANEL);
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
        menuBar.add(menu);

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

    public JPanel createSellingPanel() {

        JPanel panel = new JPanel();
        setLayout(new GridBagLayout());

        JLabel lName = new JLabel("Enter you name:");
        JTextField tfName = new JTextField(20);
        panel.add(lName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));
        panel.add(tfName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));

        JLabel lNameBird = new JLabel("Product:");
        panel.add(lNameBird, initGridBagConstrains(1, GridBagConstraints.RELATIVE));

        JPanel panelSelectProduct = new JPanel();

        panelSelectProduct.setLayout(new GridLayout(4, 2));
        panelSelectProduct.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        ButtonGroup rbGroup = new ButtonGroup();

        for (Product product : shop.getListProduct()) {
            JRadioButton rb = new JRadioButton(product.getName()); // + "; price: " + b.getPrice());
            rb.setActionCommand(product.getName());
            rbGroup.add(rb);

            JLabel lPrice = new JLabel(" " + product.getPrice() + "$");
            panelSelectProduct.add(rb);
            panelSelectProduct.add(lPrice);
        }
        panel.add(panelSelectProduct, initGridBagConstrains(1, GridBagConstraints.RELATIVE));

        NumberFormat nf = NumberFormat.getIntegerInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(15);
        tfCount.setValue(0);

        JLabel lCount = new JLabel("Enter count:");

        panel.add(lCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));
        panel.add(tfCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));

        btnBye = new JButton("BUY");
        btnBye.setActionCommand("btn_buy");
        panel.add(btnBye, initGridBagConstrains(4, 1));

        return panel;
    }

    private GridBagConstraints initGridBagConstrains(int row, int cell){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = 1; //GridBagConstraints.REMAINDER;
        c.gridx = cell; //GridBagConstraints.RELATIVE;
        c.gridy = row;
        c.insets = new Insets(0, 0, 20, 20); // top left bottom right
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        return c;
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
        btnBye.addActionListener(listener);
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
