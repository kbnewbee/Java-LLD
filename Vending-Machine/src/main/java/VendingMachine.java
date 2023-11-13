package main.java;

import main.java.inventory.Inventory;
import main.java.inventory.Product;
import main.java.states.DispenseState;
import main.java.states.HasCoinState;
import main.java.states.IdleState;
import main.java.states.State;

public class VendingMachine {

    private IdleState idleState;
    private HasCoinState hasCoinState;
    private DispenseState dispenseState;
    private State curVendingMachineState;
    private double amountInserted;
    private Inventory inventory;
    private static final int AISLE_COUNT = 3;

    public VendingMachine() {
        idleState = new IdleState(this);
        hasCoinState = new HasCoinState(this);
        dispenseState = new DispenseState(this);
        curVendingMachineState = idleState;
        amountInserted = 0.0;
        inventory = new Inventory(3);
    }

    /*
        This method acts as a public API which is exposed to the user to allow them to
        insert coins into the vending machine.
     */
    public void insertCoin(double amount) {
        this.curVendingMachineState.insertCoin(amount);
        System.out.println("Coin inserted = " + amount);
    }

    /*
        This method acts as a public API which is exposed to the user to select a specific
        product which they want to buy.
     */
    public void selectProduct(int aisleNumber) {
        this.curVendingMachineState.selectProduct(aisleNumber);
        this.curVendingMachineState.dispenseProduct(aisleNumber);
    }

    public boolean hasSufficientAmount(double price) {
        return price <= this.amountInserted;
    }

    /*
        For admin
     */
    public void addProduct(Product product) {
        try {
            this.inventory.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        Getters and Setters
     */
    public IdleState getIdleState() {
        return idleState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public HasCoinState getHasCoinState() {
        return hasCoinState;
    }

    public void setHasCoinState(HasCoinState hasCoinState) {
        this.hasCoinState = hasCoinState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getCurVendingMachineState() {
        return curVendingMachineState;
    }

    public void setCurVendingMachineState(State curVendingMachineState) {
        this.curVendingMachineState = curVendingMachineState;
    }

    public double getAmountInserted() {
        return amountInserted;
    }

    public void setAmountInserted(double amountInserted) {
        this.amountInserted = amountInserted;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
