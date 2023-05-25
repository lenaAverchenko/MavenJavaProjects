package org.telran.prof.com.classwork27;

public class ExampleArrayCountSum implements Runnable {
    private int start;
    private int end;
    private int[] array;

    public ExampleArrayCountSum(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        try {
            printArraySum(start,end,array);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void printArraySum(int start, int end, int[] array) throws InterruptedException {
        long sum = 0;
        for (int i = start; i < end; i++) {
            if (array[i]%2 == 0 ){
                sum += array[i];
                Thread.sleep(1);// заглушка, чтобы увеличить время
            }
        }
        System.out.println("Sum from " + start + " to " + end + " is " + sum);
    }
}
