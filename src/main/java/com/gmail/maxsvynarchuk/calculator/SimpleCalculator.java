package com.gmail.maxsvynarchuk.calculator;

import org.mariuszgromada.math.mxparser.Expression;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCalculator implements Calculator {
    //    Log4j API
//    private static final Logger logger = LogManager.getLogger(SimpleCalculator.class);

    //    SLF4J API
    private static final Logger logger = LoggerFactory.getLogger(SimpleCalculator.class);

    @Override
    public double addition(double a, double b) {
        logger.debug("Calculate 'addition' operation for {} and {}", a, b);

        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        logger.debug("Calculate 'subtraction' operation for {} and {}", a, b);

        return a - b;
    }

    @Override
    public double calculateAnything(String stringExpression) {
        logger.debug("Calculate expression: '{}'", stringExpression);
        Expression expression = new Expression(stringExpression);
        if (expression.checkSyntax()) {
            return expression.calculate();
        }
        logger.error("Invalid expression: '{}'", stringExpression);
        throw new IllegalArgumentException();
    }

}
