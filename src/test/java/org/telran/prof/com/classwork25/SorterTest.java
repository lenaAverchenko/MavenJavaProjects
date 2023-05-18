package org.telran.prof.com.classwork25;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    private List<Integer> integerList =  Arrays.asList(1,2,3,6,5,9,8,7);

    private Sorter sorter;
    private String s = integerList.toString();

    @BeforeEach
    void init() {
        System.out.println("Before each test");
        sorter = new Sorter();
    }

    @Test
    void sortNatural() {

        String expected = Arrays.asList(1,2,3,5,6,7,8,9).toString();
        sorter.sortNatural(integerList);
        Assertions.assertEquals(expected,s);
    }

    @Test
    void sortReverse() {
        String expected = Arrays.asList(9,8,7,6,5,3,2,1).toString();
        sorter.sortReverse(integerList);
        Assertions.assertEquals(expected,s);
    }

    @Test
    void sortNaturalWhenCollectionIsNull() {
        sorter.sortNatural(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sorter.sortNatural(null);
        });
    }

    @Test
    void collectIntegerListToString(){
        String result = sorter.getCollectionAsString(integerList);
        Assertions.assertEquals("12365987",result);
//        String join = String.join("",integers.stream().map(s ->String.valueOf(s)).collect(Collectors.toList()));
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After each test");
    }
}