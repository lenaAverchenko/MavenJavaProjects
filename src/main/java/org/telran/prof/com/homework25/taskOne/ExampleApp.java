package org.telran.prof.com.homework25.taskOne;

public class ExampleApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int[] array = {1, 4, 3, 6, 5, 7, 9, 8};
        int[] arrayTwo = {};
        System.out.println("The max element of the array is: " + calculator.getMaxInArray(array));
        System.out.println("The min element of the array is: " + calculator.getMinInArray(array));
        System.out.println("The max element of the array is: " + calculator.getMaxInArray(arrayTwo));
        System.out.println("The min element of the array is: " + calculator.getMinInArray(arrayTwo));
        System.out.println("The max element of the array is: " + calculator.getMaxInArray(null));
        System.out.println("The min element of the array is: " + calculator.getMinInArray(null));
    }
}
