package main.java;

import java.util.concurrent.atomic.AtomicInteger;

public class App {

    private static AtomicInteger val = new AtomicInteger(1);

    public static void main(String[] args) {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (val.get() <= 10) {
                    synchronized (val) {
                        if (val.get() % 2 == 0) {
                            System.out.println(val.getAndIncrement());
                        } else {
                            System.out.println(val.getAndIncrement());
                        }
                    }
                }
            }
        };

        Thread odd = new Thread(task);
        Thread even = new Thread(task);

        odd.start();
        even.start();
    }
}
