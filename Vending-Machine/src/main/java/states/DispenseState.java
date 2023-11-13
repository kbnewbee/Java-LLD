package main.java.states;

import main.java.VendingMachine;
import main.java.inventory.Inventory;
import main.java.inventory.Product;

/*
    DispenseState
    - Final state when a customer has successfully selected a specific product from the machine
    - it will not allow insertCoin(double amount) and selectProduct(int aisleNumber) methods now
    - it will only allow dispenseProduct(int aisleNumber) method

 */
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

    /*
        This method will dispense the selected product using the aisleNumber of that product
        - then it decrements the total count of that specific product by one from the inventory
        - then it calculates the currency change which it might need to return to the customer
        - then it resets the amount in the vending machine to zero
        - after dispensing the product, the state of the vending machine would change
          DispenseState -> IdleState

     */
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
