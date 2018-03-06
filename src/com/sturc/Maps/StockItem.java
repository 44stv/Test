package com.sturc.Maps;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public void setPrice(double price) {
        if (price > 0.0)
            this.price = price;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int availableToReserve() {
        return quantityInStock - reserved;
    }

    public int reserve(int quantityToReserve) {
        if ((quantityToReserve <= availableToReserve()) && (quantityToReserve > 0)) {
            this.reserved += quantityToReserve;
            return quantityToReserve;
        }
        return 0;
    }

    public int unreserve(int quantityToUnreserve) {
        if ((quantityToUnreserve <= reserved) && (quantityToUnreserve > 0)) {
            reserved -= quantityToUnreserve;
            return quantityToUnreserve;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }

        return 0;
    }

    @Override
    public int hashCode() {
        final int primeNumber = 31;
        int result = 1;

        // mistake to create hashcode using parameter, which could change
        //result = result * primeNumber + this.quantityInStock;
        result = result * primeNumber + this.name.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering stockItem.equals()");
        if (obj == this) {
            return true;
        }

        if ((obj == null) || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);

    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering stockItem.compareTo()");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityInStock;
    }
}
