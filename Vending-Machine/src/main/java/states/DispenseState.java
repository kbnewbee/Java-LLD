package main.java.states;

import main.java.VendingMachine;
import main.java.inventory.Inventory;
import main.java.inventory.Product;

public class DispenseState implements State {

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Not accepting coins, Product is already in the process of dispensing ....");
    }

    @Override
    public void selectProduct(int aisleNumber) {
        throw new IllegalStateException("Cannot select Product now, Product is already in the process of dispensing ....");
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(aisleNumber);

        inventory.decrementProductCount(aisleNumber);
        double changeToReturn = vendingMachine.getAmountInserted() - product.getPrice();

        vendingMachine.setAmountInserted(0);
        vendingMachine.setCurVendingMachineState(vendingMachine.getIdleState());

        System.out.println("Product dispensed : " + product.getName());
        System.out.println("Change returned : " + changeToReturn);

    }
}
