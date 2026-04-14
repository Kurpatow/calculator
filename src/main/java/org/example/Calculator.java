package org.example;

import java.util.Random;

public class Calculator {

    private final Random random = new Random();

    public double add(double a, double b) {
        simulateRandomDelay();
        return a + b;
    }

    public double divide(double a, double b) {
        simulateRandomDelay();
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    private void  simulateRandomDelay() {
        try {
            int millis = random.nextInt(1000);
            System.out.printf("%nRandom delay: %s ms%n", millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
