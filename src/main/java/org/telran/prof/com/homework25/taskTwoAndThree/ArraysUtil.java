package org.telran.prof.com.homework25.taskTwoAndThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysUtil {

    public ArraysUtil() {
    }

    public Integer[] getTheCommonNumbers(Integer[] array1, Integer[] array2){
        if(array1 == null || array2 == null){
            throw new IllegalArgumentException("There is no array to compare");
        }
        List <Integer> commonIntegers = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i]==array2[j]){
                    commonIntegers.add(array1[i]);
                    continue;
                }
            }
        }
        return commonIntegers.toArray(new Integer[0]);
    }

    public Integer[] deleteRepeatedElements(int[] array){
        if (array == null){
            throw new IllegalArgumentException("There is no array to work with.");
        }
        List<Integer> ints = new ArrayList<>();
        List<Integer> inputArray = Arrays.stream(array).boxed().collect(Collectors.toList());
        inputArray.forEach(i -> {
            if (!ints.contains(i)){
                ints.add(i);
            }
        });
        return ints.toArray(new Integer[0]);
    }

}
