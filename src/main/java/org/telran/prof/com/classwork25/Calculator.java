package org.telran.prof.com.classwork25;

public class Calculator {

    public int add(int a, int b){
        if (a<0 || b<0){
            return  -1;
        }
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }
}
