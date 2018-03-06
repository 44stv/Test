package com.sturc.Maps;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.finaliseStock(quantity);
        }

        return 0;
    }

    public int reserveStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);

        if ((inStock != null) && (inStock.availableToReserve() > quantity) && (quantity > 0)) {
            inStock.reserve(quantity);
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);

        if ((inStock != null) && (quantity > 0)) {
            inStock.unreserve(quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String result = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            result = result + stockItem + ". There are " + stockItem.quantityInStock() +
                    " in stock. Value of items: " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return result + "Total stock value: " + String.format("%.2f", totalCost);
    }
}
