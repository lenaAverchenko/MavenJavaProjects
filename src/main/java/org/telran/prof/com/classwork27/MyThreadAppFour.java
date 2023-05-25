package org.telran.prof.com.classwork27;

public class MyThreadAppFour {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        ExampleArrayCountSum exampleArrayCountSum1 = new ExampleArrayCountSum(0, 250, array);
        ExampleArrayCountSum exampleArrayCountSum2 = new ExampleArrayCountSum(250, 500, array);
        ExampleArrayCountSum exampleArrayCountSum3 =new ExampleArrayCountSum(500,750,array);
        ExampleArrayCountSum exampleArrayCountSum4 = new ExampleArrayCountSum(750, array.length, array);


        Thread threadOne = new Thread(exampleArrayCountSum1);
        Thread threadTwo = new Thread(exampleArrayCountSum2);
        Thread threadThree = new Thread(exampleArrayCountSum3);
        Thread threadFour = new Thread(exampleArrayCountSum4);



        long start = System.currentTimeMillis();
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        long end = System.currentTimeMillis();
        System.out.println("Time is: " + (end - start));
    }
}
