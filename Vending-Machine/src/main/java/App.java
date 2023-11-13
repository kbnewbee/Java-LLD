package main.java;

import main.java.inventory.Product;

public class App {
    private static final int AISLE_COUNT = 3;
    private static final int MAX_PRODUCT_COUNT = 3;
    public static void main(String[] args) {
        /*
            Vending machine has 3 aisles - so 3 kinds of product
            1 - lays
            2 - kitkat
            3 - pepsi

         */
        VendingMachine vendingMachine = new VendingMachine(AISLE_COUNT);

        Product lays = new Product(1, "lays", 10.0);
        Product kitkat = new Product(2, "kitkat", 40.0);
        Product pepsi = new Product(3, "pepsi", 20.0);

        // Admin operations - adding products into the inventory
        for (int i = 0; i < MAX_PRODUCT_COUNT; i++) {
            vendingMachine.addProduct(lays);
        }

        for (int i = 0; i < MAX_PRODUCT_COUNT; i++) {
            vendingMachine.addProduct(kitkat);
        }

        for (int i = 0; i < MAX_PRODUCT_COUNT; i++) {
            vendingMachine.addProduct(pepsi);
        }

        // Customer operations

        vendingMachine.insertCoin(10.0);
        vendingMachine.selectProduct(1);

        vendingMachine.insertCoin(10.0);
        vendingMachine.insertCoin(30.0);
        vendingMachine.selectProduct(2);

        vendingMachine.insertCoin(20.0);
        vendingMachine.insertCoin(30.0);
        vendingMachine.selectProduct(2);

    }
}
