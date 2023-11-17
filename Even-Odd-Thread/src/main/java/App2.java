package main.java;

public class App2 {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread odd = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
            }
        });

        Thread even = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
            }
        });

        odd.start();
        even.start();
    }
}
