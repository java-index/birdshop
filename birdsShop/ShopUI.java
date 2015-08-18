package birdsShop;

import birdsShop.Birds.*;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by rabota on 16.08.15.
 */
public class ShopUI {

    private Shop shop;
    String stringNameBtn;

    public ShopUI(Shop shop){
        this.shop = shop;
        JFrame frame = new JFrame("My SHOP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setLocation(100, 100);
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = 1; //GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 20, 20); // top left bottom right
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        /* first row */
        JLabel lName = new JLabel("Enter you name:");
        JTextField tfName = new JTextField(20);
        panel.add(lName, c);
        panel.add(tfName, c);

        JLabel lNameBird = new JLabel("Birds:");

        JPanel panelSelectBird = new JPanel();
        panelSelectBird.setLayout(new GridLayout(shop.getListBirds().size(), 2));
        panelSelectBird.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        ButtonGroup rbGroup = new ButtonGroup();

        for(ItemStoreDB  item : shop.getListStoreDB()){
            JRadioButton rb = new JRadioButton(item.getBird().getNameBird()); // + "; price: " + b.getPrice());
            rb.setActionCommand(item.getBird().getNameBird());
            rbGroup.add(rb);
            JLabel lPrice = new JLabel(" " + Double.toString(item.getBird().getPrice()) + "$");
            panelSelectBird.add(rb);
            panelSelectBird.add(lPrice);
        }

        c.gridy = 1; // second row
        panel.add(lNameBird, c);
        panel.add(panelSelectBird, c);

        NumberFormat nf = NumberFormat.getIntegerInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(15);
        tfCount.setValue(0);

        JLabel lCount = new JLabel("Enter count:");

        c.gridy = 3; // second row
        panel.add(lCount, c);
        panel.add(tfCount, c);

        JButton btnBye = new JButton("BYE");
        c.gridx = 1;
        c.gridy = 4;
        panel.add(btnBye, c);

        btnBye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer c = new Customer(tfName.getText());
                String str = rbGroup.getSelection().getActionCommand();
                Bird b = shop.getBirdByName(str);
                int count = Integer.parseInt(tfCount.getText());
                shop.addTransaction(c, b, count, Category.NONE);
                new Printer(shop).printTransactions();
                //System.out.println(str);
            }
        });
        return panel;
    }

}
