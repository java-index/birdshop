package birdsShop.shopView;

import birdsShop.domain.Product;
import birdsShop.domain.Shop;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by dasha on 31.08.15.
 */
public class SellingViewPanel extends JPanel{

    private JButton btnBuy;
    private JTextField tfUserName;
    private JFormattedTextField tfCount;
    private ButtonGroup rbGroup;
    private JPanel panelSelectProduct;

    public SellingViewPanel(Shop<? extends Product> shop){

        setLayout(new GridBagLayout());

        JLabel lUserName = new JLabel("Enter you name:");
        tfUserName = new JTextField(20);
        add(lUserName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));
        add(tfUserName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));

        JLabel lNameBird = new JLabel("Product:");
        add(lNameBird, initGridBagConstrains(1, GridBagConstraints.RELATIVE));

        /* radio button panel*/
        panelSelectProduct = new JPanel();
        panelSelectProduct.setLayout(new GridLayout(shop.getListProduct().size(), 3));
        panelSelectProduct.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        rbGroup = new ButtonGroup();
        for (Product product : shop.getListProduct()) {
            JRadioButton rb = new JRadioButton(product.getName(), true);
            rb.setActionCommand(product.getName());
            rbGroup.add(rb);
            rbGroup.getSelection().getActionCommand();
            JLabel lPrice = new JLabel("  " + product.getPrice() + " $");
            JLabel lQuantity = new JLabel("qty: " + product.getQuantity() + " in.");
            panelSelectProduct.add(rb);
            panelSelectProduct.add(lPrice);
            panelSelectProduct.add(lQuantity);
        }
        add(panelSelectProduct, initGridBagConstrains(1, GridBagConstraints.RELATIVE));

        NumberFormat nf = NumberFormat.getIntegerInstance();
        tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(15);
        tfCount.setValue(0);

        JLabel lCount = new JLabel("Enter count:");
        add(lCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));
        add(tfCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));

        btnBuy = new JButton("BUY");
        btnBuy.setActionCommand("btn_buy");
        add(btnBuy, initGridBagConstrains(4, 1));
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

    public JButton getBtnBuy() {
        return btnBuy;
    }

    public JTextField getTfUserName() {
        return tfUserName;
    }

    public void setTfUserName(JTextField tfUserName) {
        this.tfUserName = tfUserName;
    }

    public JFormattedTextField getTfCount() {
        return tfCount;
    }

    public ButtonGroup getRbGroup() {
        return rbGroup;
    }

    public void repaintPanel(Shop<?> shop){
        panelSelectProduct.removeAll();
        rbGroup = new ButtonGroup();
        for (Product product : shop.getListProduct()) {
            JRadioButton rb = new JRadioButton(product.getName(), true);
            rb.setActionCommand(product.getName());
            rbGroup.add(rb);
            rbGroup.getSelection().getActionCommand();
            JLabel lPrice = new JLabel("  " + product.getPrice() + " $");
            JLabel lQuantity = new JLabel("qty: " + product.getQuantity() + " in.");
            panelSelectProduct.add(rb);
            panelSelectProduct.add(lPrice);
            panelSelectProduct.add(lQuantity);
        }
        add(panelSelectProduct, initGridBagConstrains(1, GridBagConstraints.RELATIVE));
        repaint();
    }
}
