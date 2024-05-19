package view;

import javax.swing.*;
import main.Shop;

public class CashView extends JDialog {
    public CashView(JFrame parent, Shop shop) {
        super(parent, "Contar caja", true);
        setSize(300, 200);
        setLayout(null);

        JLabel label = new JLabel("Dinero en caja:");
        label.setBounds(50, 50, 100, 30);
        add(label);

        JTextField cashField = new JTextField(String.valueOf(shop.getCash()));
        cashField.setBounds(150, 50, 100, 30);
        cashField.setEditable(false);
        add(cashField);

        JButton okButton = new JButton("OK");
        okButton.setBounds(100, 100, 80, 30);
        okButton.addActionListener(e -> dispose());
        add(okButton);
    }
}
