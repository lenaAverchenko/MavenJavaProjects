package org.telran.prof.com.homework25.taskTwoAndThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class ArraysUtilTest {
    private ArraysUtil arraysUtil = new ArraysUtil();
    private int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
    private int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

    @Test
    void getTheCommonNumbers() {
        int[] expected = {1, 7};
        int[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(array1, array2);
        Assertions.assertArrayEquals(expected, resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfFirstArrayIsEmpty() {
        int[] expected = {};
        int[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(new int[0], array2);
        Assertions.assertArrayEquals(expected, resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfSecondArrayIsEmpty() {
        int[] expected = {};
        int[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(array1, new int[0]);
        Assertions.assertArrayEquals(expected, resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfFirstArrayForCheckIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.getTheCommonNumbers(null, array2));
    }

    @Test
    void getTheCommonNumbersIfSecondArrayForCheckIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.getTheCommonNumbers(array1, null));
    }

    @Test
    void deleteRepeatedElements() {
        int[] array = {1, 5, 8, 7, 9, 6, 1, 5, 9, 3};
        int[] expected = {1, 5, 8, 7, 9, 6, 3};
        int[] resultOfMethodsWork = arraysUtil.deleteRepeatedElements(array);
        Assertions.assertArrayEquals(expected, resultOfMethodsWork);
    }

    @Test
    void deleteRepeatedElementsWithTheNullInputArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.deleteRepeatedElements(null));
    }
}