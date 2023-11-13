package main.java.states;

import main.java.VendingMachine;
import main.java.inventory.Inventory;
import main.java.inventory.Product;

public class HasCoinState implements State {

    private final VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmountInserted(vendingMachine.getAmountInserted() + amount);
    }

    @Override
    public void selectProduct(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(aisleNumber);

        if (!vendingMachine.hasSufficientAmount(product.getPrice())) {
            throw new IllegalStateException("Insufficient amount to buy this product");
        }

        if (!inventory.checkProductAvailability(product.getId())) {
            throw new IllegalStateException("Product is not available right now");
        }

        vendingMachine.setCurVendingMachineState(vendingMachine.getDispenseState());
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        throw new IllegalStateException("No product is selected ....");
    }
}
