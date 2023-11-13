package main.java;

import main.java.inventory.Product;

public class App {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product lays = new Product(1, "lays", 10.0);
        Product kitkat = new Product(2, "kitkat", 40.0);
        Product pepsi = new Product(3, "pepsi", 20.0);

        // adding the products into the inventory
        for (int i = 0; i < 3; i++) {
            vendingMachine.addProduct(lays);
        }

        for (int i = 0; i < 3; i++) {
            vendingMachine.addProduct(kitkat);
        }

        for (int i = 0; i < 3; i++) {
            vendingMachine.addProduct(pepsi);
        }


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
