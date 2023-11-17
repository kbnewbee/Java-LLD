package main.java;

public class Printer {
    private int curVal = 1;
    private final int maxVal = 10;

    synchronized public void printOdd() throws InterruptedException {
        while (curVal <= maxVal) {
            while (curVal % 2 == 0) {
                wait();
            }
            System.out.println(curVal);
            curVal++;
            notifyAll();
        }
    }

    synchronized public void printEven() throws InterruptedException {
        while (curVal <= maxVal) {
            while (curVal % 2 != 0) {
                wait();
            }
            System.out.println(curVal);
            curVal++;
            notifyAll();
        }
    }
}
