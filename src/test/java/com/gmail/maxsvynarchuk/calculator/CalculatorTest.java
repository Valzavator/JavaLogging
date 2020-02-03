package com.gmail.maxsvynarchuk.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final static double DELTA = 0.001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new SimpleCalculator();
    }

    @Test
    void additionTest() {
        double a = 2;
        double b = 3;
        double expected = 5;

        assertEquals(expected, calculator.addition(a, b), DELTA);
    }

    @Test
    void subtractionTest() {
        double a = 2;
        double b = 3;
        double expected = -1;

        assertEquals(expected, calculator.subtraction(a, b));
    }

    @Test
    void calculateAnythingTest() {
        String expression = "2*int(sqrt(1-x^2), x, -1, 1)";
        double expected = Math.PI;

        assertEquals(expected, calculator.calculateAnything(expression), DELTA);
    }

    @Test
    void calculateAnythingExceptionTest() {
        String invalidExpression = "2*int(sqrtqq(1-x^2), x, -1, 1)";

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAnything(invalidExpression));
    }
}