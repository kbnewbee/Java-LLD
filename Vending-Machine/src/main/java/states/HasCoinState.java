package main.java.states;

import main.java.VendingMachine;
import main.java.inventory.Inventory;
import main.java.inventory.Product;

/*
    HasCoinState
    - Intermediate state when a customer has inserted some amount of money into the machine
    - it will still allow insertCoin(double amount) method, but will not change the state
    - it will now allow selectProduct(int aisleNumber) method
    - last method will throw exception as product is not ready to be dispensed from the machine

 */
public class HasCoinState implements State {

    private final VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmountInserted(vendingMachine.getAmountInserted() + amount);
    }

    /*
        This method will allow the user to select the product using the aisleNumber
        which is like a product code to identify a specific product.
        - It will check if the vending machine has sufficient amount inserted to buy
          the specific selected product, otherwise throw exception
        - then it will check whether the product is available in the inventory of the machine
        - after these two checks are successful, then only the vending machine would go to its next state
          HashCoinState -> DispenseState

     */
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
