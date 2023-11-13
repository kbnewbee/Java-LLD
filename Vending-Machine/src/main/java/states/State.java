package main.java.states;

/*
    Vending Machine state lifecycle
    IdleState -> HasCoinState -> DispenseState -> IdleState
 */
public interface State {

    public void insertCoin(double amount);
    public void selectProduct(int aisleNumber);
    public void dispenseProduct(int aisleNumber);
}
