package org.telran.prof.com.classwork25;

import java.util.Arrays;
import java.util.List;

public class ExampleApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(10,5));

        List<Integer> integerList =  Arrays.asList(1,2,3,6,5,7,8,9);
        Sorter sorter = new Sorter();
        sorter.sortNatural(integerList);
        System.out.println(integerList);

        sorter.sortReverse(integerList);
        System.out.println(integerList);

    }
}
