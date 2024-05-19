package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private Map<String, Product> inventory;
    private double cash;

    public Shop() {
        inventory = new HashMap<>();
        cash = 100.0; 
    }

    public void loadInventory() {
        inventory.put("Producto 1", new Product("Producto 1", 10, 50.0));
        inventory.put("Producto 2", new Product("Producto 2", 5, 30.0));
        inventory.put("Producto 3", new Product("Producto 3", 15, 20.0));
    }

    public double getCash() {
        return cash;
    }

    public boolean addProduct(String name, int stock, double price) {
        if (inventory.containsKey(name)) {
            return false;
        }
        inventory.put(name, new Product(name, stock, price));
        return true;
    }

    public boolean deleteProduct(String name) {
        return inventory.remove(name) != null;
    }

    public boolean addStock(String name, int stock) {
        Product product = inventory.get(name);
        if (product != null) {
            product.setStock(product.getStock() + stock);
            return true;
        }
        return false;
    }

    // Clase interna para el producto
    class Product {
        private String name;
        private int stock;
        private double price;

        public Product(String name, int stock, double price) {
            this.name = name;
            this.stock = stock;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public double getPrice() {
            return price;
        }
    }
}
