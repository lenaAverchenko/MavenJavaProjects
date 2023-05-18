package org.telran.prof.com.classwork25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    private final int a = 10;
    private final int b = 5;

    @Test
    void add() {
//        int res = calculator.add(a,b);
        Assertions.assertEquals(15, calculator.add(a,b));
    }

    @Test
    void sub() {
        Assertions.assertEquals(5, calculator.sub(a,b));
    }

    @Test
    void addWhenFirstParameterLessThanZero() {
        Assertions.assertEquals(-1, calculator.add(-1,b));
    }

    @Test
    void addWhenSecondParameterLessThanZero() {
        Assertions.assertEquals(-1, calculator.add(a,-1));
    }


}