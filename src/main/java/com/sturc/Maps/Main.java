package com.sturc.Maps;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket1 = new Basket("Basket1");
        sellItem(basket1, "car", 1);
        System.out.println(basket1);

        sellItem(basket1, "car", 1);
        System.out.println(basket1);

        if (sellItem(basket1, "car", 1) != 1) {
            System.out.println("There no more cars in stock.");
        }

        sellItem(basket1, "spanner", 1);

        sellItem(basket1, "juice", 4);
        sellItem(basket1, "cup", 12);
        sellItem(basket1, "bread", 1);

        Basket basket2 = new Basket("Basket2");
        sellItem(basket2, "cup", 100);
        sellItem(basket2, "juice", 5);
        removeItem(basket2, "cup", 1);
        System.out.println(basket2);

        removeItem(basket1, "car", 1);
        removeItem(basket1, "cup", 9);
        removeItem(basket1, "car", 1);
        System.out.println("Cars removed: " + removeItem(basket1, "car", 1));

        System.out.println(basket1);

        //remove all items
        removeItem(basket1, "bread", 1);
        removeItem(basket1, "cup", 3);
        removeItem(basket1, "juice", 4);
        removeItem(basket1, "cup", 3);
        System.out.println(basket1);

        System.out.println(basket2);
        System.out.println(stockList);
        checkout(basket2);
        System.out.println(basket2);
        System.out.println(stockList);

        checkout(basket1);
        System.out.println(stockList);
    }

    private static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don`t sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    private static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don`t sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    private static void checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
