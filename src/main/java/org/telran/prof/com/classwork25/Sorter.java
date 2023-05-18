package org.telran.prof.com.classwork25;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

//    Comparator<Integer> comparator = (o1,o2) -> o1.compareTo(o2);

    public void sortNatural (List<Integer> integerList){
        if (integerList == null){
            throw new IllegalArgumentException();
        }
        Collections.sort(integerList);
    }

    public void sortReverse (List<Integer> integerList){
        Collections.sort(integerList, Comparator.reverseOrder());
    }

    public  String getCollectionAsString(List<Integer> integers){
        return integers.stream().map(String:: valueOf).collect(Collectors.joining());
//        String join = String.join("",integers.stream().map(s ->String.valueOf(s)).collect(Collectors.toList()));
    }
}
