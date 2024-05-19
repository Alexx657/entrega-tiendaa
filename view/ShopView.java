package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Shop;  

public class ShopView extends JFrame implements ActionListener, KeyListener {
    private JButton countCashButton;
    private JButton addProductButton;
    private JButton addStockButton;
    private JButton deleteProductButton;
    private Shop shop;

    public ShopView() {
        // Configuración del JFrame
        setTitle("Menú principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Inicializar el objeto shop y cargar inventario
        shop = new Shop();
        shop.loadInventory();

        // Crear y agregar botones
        countCashButton = new JButton("1. Contar caja");
        countCashButton.setBounds(50, 30, 300, 40);
        add(countCashButton);

        addProductButton = new JButton("2. Añadir producto");
        addProductButton.setBounds(50, 80, 300, 40);
        add(addProductButton);

        addStockButton = new JButton("3. Añadir stock");
        addStockButton.setBounds(50, 130, 300, 40);
        add(addStockButton);

        deleteProductButton = new JButton("9. Eliminar producto");
        deleteProductButton.setBounds(50, 180, 300, 40);
        add(deleteProductButton);

        // Añadir ActionListener a los botones
        countCashButton.addActionListener(this);
        addProductButton.addActionListener(this);
        addStockButton.addActionListener(this);
        deleteProductButton.addActionListener(this);

        // Añadir KeyListener al frame
        addKeyListener(this);
        setFocusable(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countCashButton) {
            openCashView();
        } else if (e.getSource() == addProductButton) {
            openProductView("Añadir producto");
        } else if (e.getSource() == addStockButton) {
            openProductView("Añadir stock");
        } else if (e.getSource() == deleteProductButton) {
            openProductView("Eliminar producto");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                openCashView();
                break;
            case KeyEvent.VK_2:
                openProductView("Añadir producto");
                break;
            case KeyEvent.VK_3:
                openProductView("Añadir stock");
                break;
            case KeyEvent.VK_9:
                openProductView("Eliminar producto");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void openCashView() {
        CashView cashView = new CashView(this, shop);
        cashView.setVisible(true);
    }

    private void openProductView(String option) {
        ProductView productView = new ProductView(this, option, shop);
        productView.setVisible(true);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de ShopView
        ShopView shopView = new ShopView();
        shopView.setVisible(true);
    }
}
