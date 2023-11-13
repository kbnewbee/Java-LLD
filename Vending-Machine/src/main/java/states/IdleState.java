package main.java.states;

import main.java.VendingMachine;

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
