package org.telran.prof.com.homework25.taskTwoAndThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class ArraysUtilTest {
    private ArraysUtil arraysUtil = new ArraysUtil();
    private Integer[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
    private Integer[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

    @Test
    void getTheCommonNumbers() {
        Integer[] expected = {1,7};
        Integer[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(array1,array2);
        Assertions.assertArrayEquals(expected,resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfFirstArrayIsEmpty() {
        Integer[] expected = {};
        Integer[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(new Integer[0],array2);
        Assertions.assertArrayEquals(expected,resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfSecondArrayIsEmpty() {
        Integer[] expected = {};
        Integer[] resultOfTheMethod = arraysUtil.getTheCommonNumbers(array1,new Integer[0]);
        Assertions.assertArrayEquals(expected,resultOfTheMethod);
    }

    @Test
    void getTheCommonNumbersIfFirstArrayForCheckIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.getTheCommonNumbers(null,array2));
    }

    @Test
    void getTheCommonNumbersIfSecondArrayForCheckIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.getTheCommonNumbers(array1, null));
    }

    @Test
    void deleteRepeatedElements(){
        int[] array = {1,5,8,7,9,6,1,5,9,3};
        int[] expected = {1, 5, 8, 7, 9, 6, 3};
        Integer[] resultOfMethodsWork = arraysUtil.deleteRepeatedElements(array);
        Assertions.assertArrayEquals(Arrays.stream(expected).boxed().toArray(), resultOfMethodsWork);
    }

    @Test
    void deleteRepeatedElementsWithTheNullInputArray(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> arraysUtil.deleteRepeatedElements(null));
    }
}