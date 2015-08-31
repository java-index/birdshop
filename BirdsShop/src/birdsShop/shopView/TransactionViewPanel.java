package birdsShop.shopView;

import birdsShop.domain.Product;
import birdsShop.domain.Shop;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by rabota on 30.08.15.
 */
public class TransactionViewPanel extends JPanel{

    Shop<?> shop;
    private JTable table;
    String[][] tableSource;
    String[] columnNames = {"ID", "Date", "Customer name", "Product name", "Price", "Quantity"};

    public TransactionViewPanel(Shop<? extends Product> shop){
        this.shop = shop;
        tableSource = this.shop.getTransactionArray();
        initTable();
    }

    public void updatePanel(){
        removeAll();
        tableSource = shop.getTransactionArray();
        initTable();
    }

    private void initTable(){
        table = new JTable(tableSource, columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        add(scrollPane);
    }
}
