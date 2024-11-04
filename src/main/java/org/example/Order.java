package org.example;

import java.util.List;

public class Order {
    private List<String> items;
    private double totalPrice;

    public Order(List<String> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return items.size();
    }
}
