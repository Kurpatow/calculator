package org.example;

import org.example.extensions.TimingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(TimingExtension.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() { calculator = new Calculator(); }

    @Test
    public void testAddition() {
    double result = calculator.add(3, 7);
    assertEquals(10,result,"3 + 7 should equal 10");
    }

    @Test
    public void testDivision() {
        double result = calculator.divide(8, 2);
        assertEquals(4, result, "8 / 2 should equal 4");
    }

    @Test
    public void testDivisionByZero() { assertThrows(ArithmeticException.class, () -> calculator.divide(8, 0)); }
}
