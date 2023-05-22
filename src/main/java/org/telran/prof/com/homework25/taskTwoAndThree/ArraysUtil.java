package org.telran.prof.com.homework25.taskTwoAndThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtil {

    public ArraysUtil() {
    }

    public int[] getTheCommonNumbers(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("There is no array to compare");
        }
        List<Integer> commonIntegers = new ArrayList<>();
        List<Integer> firstArrayIntegers = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            firstArrayIntegers.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            if (firstArrayIntegers.contains(array2[i])) {
                commonIntegers.add(array2[i]);
            }
        }
        int[] commons = new int[commonIntegers.size()];
        for (int i = 0; i < commons.length; i++) {
            commons[i] = commonIntegers.get(i);
        }
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array2.length; j++) {
//                if (array1[i] == array2[j]) {
//                    commonIntegers.add(array1[i]);
//                    continue;
//                }
//            }
//        }
        return commons;
    }

    public int[] deleteRepeatedElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("There is no array to work with.");
        }
//        List<Integer> ints = new ArrayList<>();
//        List<Integer> inputArray = Arrays.stream(array).boxed().collect(Collectors.toList());
//        inputArray.forEach(i -> {
//            if (!ints.contains(i)) {
//                ints.add(i);
//            }
//        });
//        int[] deleted = new int[ints.size()];
//        for (int i = 0; i < deleted.length; i++) {
//            deleted[i] = ints.get(i);
//        }
        int[] deleted = Arrays.stream(array).distinct().toArray();

        return deleted;
    }

}
