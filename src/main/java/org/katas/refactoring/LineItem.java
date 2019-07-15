package org.katas.refactoring;

public class LineItem {
    private String desc;
    private double price;
    private int quantity;

    public LineItem(String desc, double price, int quantity) {
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    double totalAmount() {
        return this.price * this.quantity;
    }
}