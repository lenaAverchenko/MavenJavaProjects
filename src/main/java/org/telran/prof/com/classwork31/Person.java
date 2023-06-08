package org.telran.prof.com.classwork31;

import java.util.concurrent.Semaphore;

public class Person implements Runnable{

    private String personName;
    private Semaphore semaphore;
    private boolean[] freeTable;

    public Person(String personName, Semaphore semaphore, boolean[] freeTable) {
        this.personName = personName;
        this.semaphore = semaphore;
        this.freeTable = freeTable;
    }

    @Override
    public void run() {
        System.out.println("" + personName + " has come to restaurant");
        try {

            semaphore.acquire(); // запрос на наличие свободного счетчика для работы
//            semaphore.acquire(100); // при наличии дает доступ к определенному числу потоков
            int tempSeat = -1;
            synchronized (freeTable){
                for (int i = 0; i < freeTable.length; i++) {
                    // если столик был свободен
                    if (!freeTable[i]){
                        // занимаем его
                        freeTable[i] = true;
                        System.out.println("" + personName + " seats on the table number " + (i+1));
                        tempSeat = i;
                        System.out.println("");
                        break;
                    }
                }
            }

            Thread.sleep(5000); // time for eating - lunch
            //освобождаем столик после еды клиента - это освобождение только элемента массива
            synchronized (freeTable){
                freeTable[tempSeat] = false;
            }
            semaphore.release(); // освобождает счетчик, чтобы один из потоков мог дальше сажать клиента за столик
//            semaphore.release(100); // освобождает счетчик для доступа к какому-то числу потоков
            synchronized (freeTable) {
                System.out.println("" + personName + " has finished their lunch and left");
                System.out.println("Table number " + (tempSeat + 1) + " is free");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
