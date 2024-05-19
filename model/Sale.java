package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    Client client;
    List<Product> products;
    double amount;
    LocalDateTime saleDateTime;

    public Sale(Client client, ArrayList<Product> products, double totalAmount, LocalDateTime saleDateTime) {
        this.client = client;
        this.products = products;
        this.amount = totalAmount;
        this.saleDateTime = saleDateTime; // Asegúrate de que saleDateTime se inicializa correctamente aquí
    }

	public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    public String getSaleDateTimeFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return saleDateTime.format(formatter);
    }


    @Override
    public String toString() {
        return "Sale{" +
                "client='" + client + '\'' +
                ", products=" + products +
                ", amount=" + amount +
                ", saleDateTime=" + saleDateTime +
                '}';
    }

    public double getTotalAmount() {
        return amount;
    }
}
