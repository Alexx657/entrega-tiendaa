package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Shop;

public class ProductView extends JDialog implements ActionListener {
    private JTextField nameField;
    private JTextField stockField;
    private JTextField priceField;
    private JButton okButton;
    private JButton cancelButton;
    private Shop shop;
    private String option;

    public ProductView(JFrame parent, String option, Shop shop) {
        super(parent, option, true);
        this.shop = shop;
        this.option = option;

        setSize(300, 300);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nombre producto:");
        nameLabel.setBounds(20, 30, 120, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 100, 30);
        add(nameField);

        JLabel stockLabel = new JLabel("Stock producto:");
        stockLabel.setBounds(20, 80, 120, 30);
        add(stockLabel);

        stockField = new JTextField();
        stockField.setBounds(150, 80, 100, 30);
        add(stockField);

        JLabel priceLabel = new JLabel("Precio producto:");
        priceLabel.setBounds(20, 130, 120, 30);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(150, 130, 100, 30);
        add(priceField);

        okButton = new JButton("OK");
        okButton.setBounds(50, 200, 80, 30);
        okButton.addActionListener(this);
        add(okButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 200, 80, 30);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String productName = nameField.getText();
        int productStock;
        double productPrice;
        
        try {
            productStock = Integer.parseInt(stockField.getText());
            productPrice = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Stock y precio deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (option) {
            case "Añadir producto":
                if (shop.addProduct(productName, productStock, productPrice)) {
                    JOptionPane.showMessageDialog(this, "Producto añadido correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "El producto ya existe.","Error",JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Eliminar producto":
                if (shop.deleteProduct(productName)) {
                    JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "El product"
                    		+ "o no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Añadir stock":
                if (shop.addStock(productName, productStock)) {
                    JOptionPane.showMessageDialog(this, "Stock añadido correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "El producto no existe.", "Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }
}
