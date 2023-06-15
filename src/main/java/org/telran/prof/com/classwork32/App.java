package org.telran.prof.com.classwork32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int[] numbers = {1,5,4,7,8,9,2,3,6,5,4,78,51,21,63,13,20};
        int[] numbers = {1, 5, 4, 7, 8, 9, 2, 3, 6, 5, 4, 78, 51, 21, 63};
        int sum = 0;
        List<int[]> arrays = divideArray(numbers);
        for (int i = 0; i < arrays.size(); i++) {
            FutureTask futureRes = new FutureTask<>(new ArrCallable(arrays.get(i)));
            new Thread(futureRes).start();
            sum = sum + (int) futureRes.get();
        }
        System.out.println(sum);
    }

    public static List<int[]> divideArray(int[] initialArray) {
        int startIdx = 0;
        int endIdx = initialArray.length / 3;
        List<int[]> listOfArrays = new ArrayList<>();
        while (startIdx < initialArray.length) {
            int[] currentNumbers = new int[endIdx - startIdx];
            if (listOfArrays.size() == 2) {
                currentNumbers = new int[initialArray.length - startIdx];
            }
            for (int i = 0; i < currentNumbers.length; i++) {
                currentNumbers[i] = initialArray[startIdx];
                startIdx++;
            }
            endIdx = startIdx + initialArray.length / 3;
            System.out.println(Arrays.toString(currentNumbers));
            listOfArrays.add(currentNumbers);
        }
        return listOfArrays;
    }
}
