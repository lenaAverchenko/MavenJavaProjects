package org.telran.prof.com.homework25.taskOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    private int[] array = {1,4,3,6,5,7,9,8};
    @Test
    void getMaxInArray() {
        Assertions.assertEquals(9,calculator.getMaxInArray(array));
    }

    @Test
    void getMinInArray() {
        Assertions.assertEquals(1,calculator.getMinInArray(array));
    }

    @Test
    void getMaxInEmptyArray() {
        Assertions.assertEquals(0,calculator.getMaxInArray(new int[0]));
    }

    @Test
    void getMinInEmptyArray() {
        Assertions.assertEquals(0,calculator.getMinInArray(new int[0]));
    }

    @Test
    void getMaxInNullInsteadOfArray() {
//        Assertions.assertEquals(null,calculator.getMaxInArray(null));
        Assertions.assertNull(calculator.getMaxInArray(null));
    }

    @Test
    void getMinInNullInsteadOfArray() {
//        Assertions.assertEquals(null,calculator.getMinInArray(null));
        Assertions.assertNull(calculator.getMinInArray(null));
    }
}