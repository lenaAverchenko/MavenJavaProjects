package org.telran.prof.com.homework25.taskTwoAndThree;

import java.util.Arrays;

public class ArrayUtilApp {
    public static void main(String[] args) {
        ArraysUtil arraysUtil = new ArraysUtil();
        Integer[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
        Integer[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

        try {
            System.out.println(Arrays.toString(arraysUtil.getTheCommonNumbers(array1, array2)));
            System.out.println(Arrays.toString(arraysUtil.getTheCommonNumbers(new Integer[0], array2)));
            System.out.println(Arrays.toString(arraysUtil.getTheCommonNumbers(null, array2)));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        int[] arr = {1,5,8,7,9,6,1,5,9,3};
        try {
            System.out.println(Arrays.toString(arraysUtil.deleteRepeatedElements(arr)));
            System.out.println(Arrays.toString(arraysUtil.deleteRepeatedElements(null)));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
