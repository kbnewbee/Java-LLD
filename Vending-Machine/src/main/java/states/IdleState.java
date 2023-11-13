package main.java.states;

import main.java.VendingMachine;


/*
    IdleState
    - initial state when no one is using the machine
    - it will only allow insertCoin(double amount) method
    - after insertion of money, the state of the vending machine would change
      IdleState -> HasCoinState
    - rest all the methods will throw exceptions as no money
      is inserted into the machine

 */
public class IdleState implements State {

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmountInserted(amount);
        vendingMachine.setCurVendingMachineState(vendingMachine.getHasCoinState());
    }

    @Override
    public void selectProduct(int aisleNumber) {
        throw new IllegalStateException("No coin is inserted ....");
    }

    @Override
    public void dispenseProduct(int aisleNumber) {
        throw new IllegalStateException("No coin is inserted ....");
    }
}
