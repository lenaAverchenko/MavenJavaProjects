package org.telran.prof.com.homework25.taskOne;

import java.util.Arrays;

public class Calculator {

    public Integer getMaxInArray(int[] arr){
        try{
            return Arrays.stream(arr).max().orElse(0);
        }catch(NullPointerException e){
//            System.out.println("There is no array to search for a max element");
            return null;
        }
    }

    public Integer getMinInArray(int[] arr){
        try{
            return Arrays.stream(arr).min().orElse(0);
        }catch(NullPointerException e){
//            System.out.println("There is no array to search for a max element");
            return null;
    }
    }
}
