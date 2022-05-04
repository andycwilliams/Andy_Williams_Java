package com.company;

import org.junit.*;

import static java.lang.Double.NaN;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldAddInt() {
        assertEquals(1, calculator.addInt(0,1));
        assertEquals(15, calculator.addInt(9, 6));
        assertEquals(73, calculator.addInt(77, -4));
    }

    @Test
    public void shouldSubtractInt() {
        assertEquals(-5, calculator.subtractInt(6,11));
        assertEquals(9, calculator.subtractInt(12, 3));
        assertEquals(0, calculator.subtractInt(40, 40));
    }

    @Test
    public void shouldMultiplyInt() {
        assertEquals(15, calculator.multiplyInt(3,5));
        assertEquals(80, calculator.multiplyInt(8, 10));
        assertEquals(-25, calculator.multiplyInt(-5, 5));
    }

    @Test
    public void shouldDivideInt() {
        assertEquals(1, calculator.divideInt(12,12));
        assertEquals(4, calculator.divideInt(44, 11));
        assertEquals(15, calculator.divideInt(75, 5));
    }

    @Test
    public void shouldAddDouble() {
        assertEquals(8.4, calculator.addDouble(1.1,7.3), 1);
        assertEquals(5.65, calculator.addDouble(3.5, 2.15), 1);
        assertEquals(1.23, calculator.addDouble(2.34, -1.11), 1);
    }

    @Test
    public void shouldSubtractDouble() {
        assertEquals(1.26, calculator.subtractDouble(4.44,3.18), 1);
        assertEquals(1.8, calculator.subtractDouble(7.4, 5.6), 1);
        assertEquals(21.7, calculator.subtractDouble(82.78, 61.08), 1);
    }

    @Test
    public void shouldMultiplyDouble() {
        assertEquals(50.922, calculator.multiplyDouble(6.21,8.2), 1);
        assertEquals(7.56, calculator.multiplyDouble(2.7, 2.8), 1);
        assertEquals(41.44, calculator.multiplyDouble(7.4, 5.6), 1);
    }

    @Test
    public void shouldDivideDouble() {
        assertEquals(-5.96, calculator.divideDouble(-7.45,1.25), 1);
        assertEquals(5.125, calculator.divideDouble(8.2, 1.6), 1);
        assertEquals(3, calculator.divideDouble(9.99, 3.33), 1);
    }

}