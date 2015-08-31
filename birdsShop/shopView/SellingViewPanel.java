//package birdsShop.shopView;
//
//import birdsShop.domain.Product;
//
//import javax.swing.*;
//import java.awt.*;
//import java.text.NumberFormat;
//import java.util.*;
//
///**
// * Created by rabota on 30.08.15.
// */
//public class SellingViewPanel extends JPanel {
//
//    public SellingViewPanel() {
//
//        setLayout(new GridBagLayout());
//
//        /* first row */
//        JLabel lName = new JLabel("Enter you name:");
//        JTextField tfName = new JTextField(20);
//        add(lName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));
//        add(tfName, initGridBagConstrains(0, GridBagConstraints.RELATIVE));
//
//        JLabel lNameBird = new JLabel("Product:");
//        add(lNameBird, initGridBagConstrains(1, GridBagConstraints.RELATIVE));
//
//        JPanel panelSelectProduct = new JPanel();
//
//        panelSelectProduct.setLayout(new GridLayout(productList.size(), 2));
//        panelSelectProduct.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//
//        ButtonGroup rbGroup = new ButtonGroup();
//
//        for (Product product : productList) {
//            JRadioButton rb = new JRadioButton(product.getName()); // + "; price: " + b.getPrice());
//            rb.setActionCommand(product.getName());
//            rbGroup.add(rb);
//
//            JLabel lPrice = new JLabel(" " + product.getPrice() + "$");
//            panelSelectProduct.add(rb);
//            panelSelectProduct.add(lPrice);
//        }
//
//        panel.add(panelSelectProduct, initGridBagConstrains(1, GridBagConstraints.RELATIVE));
//
//        NumberFormat nf = NumberFormat.getIntegerInstance();
//        JFormattedTextField tfCount = new JFormattedTextField(nf);
//        tfCount.setColumns(15);
//        tfCount.setValue(0);
//
//        JLabel lCount = new JLabel("Enter count:");
//
//        panel.add(lCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));
//        panel.add(tfCount, initGridBagConstrains(3, GridBagConstraints.RELATIVE));
//
//        JButton btnBye = new JButton("BYE");
//        panel.add(btnBye, initGridBagConstrains(4, 1));
//
//        return panel;
//    }
//
//    public void createProductChoicePanel(java.util.List<? extends Product> productList, JPanel mainPanel){
//
//        JPanel panelSelectProduct = new JPanel();
//
//        panelSelectProduct.setLayout(new GridLayout(productList.size(), 2));
//        panelSelectProduct.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//
//        ButtonGroup rbGroup = new ButtonGroup();
//
//        for (Product product : productList) {
//            JRadioButton rb = new JRadioButton(product.getName()); // + "; price: " + b.getPrice());
//            rb.setActionCommand(product.getName());
//            rbGroup.add(rb);
//
//            JLabel lPrice = new JLabel(" " + product.getPrice() + "$");
//            panelSelectProduct.add(rb);
//            panelSelectProduct.add(lPrice);
//        }
//
//    }
//
//    private GridBagConstraints initGridBagConstrains(int row, int cell){
//        GridBagConstraints c = new GridBagConstraints();
//        c.anchor = GridBagConstraints.WEST;
//        c.fill   = GridBagConstraints.NONE;
//        c.gridheight = 1;
//        c.gridwidth  = 1; //GridBagConstraints.REMAINDER;
//        c.gridx = cell; //GridBagConstraints.RELATIVE;
//        c.gridy = row;
//        c.insets = new Insets(0, 0, 20, 20); // top left bottom right
//        c.ipadx = 0;
//        c.ipady = 0;
//        c.weightx = 0.0;
//        c.weighty = 0.0;
//        return c;
//    }
//}
