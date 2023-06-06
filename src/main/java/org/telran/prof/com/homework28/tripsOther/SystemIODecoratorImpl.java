package org.telran.prof.com.homework28.tripsOther;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.Scanner;

public class SystemIODecoratorImpl implements SystemIODecorator {

    private Queue<String> queue;

    private Scanner scanner;

    public SystemIODecoratorImpl(Scanner scanner, Queue<String> queue) {
        this.scanner = scanner;
        this.queue = queue;
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void println(String outString) {
        queue.add(outString + "\n");
        System.out.println(outString);
    }

    @Override
    public void println(Trip trip) {
        queue.add(trip.toString() + "\n");
        System.out.println(trip);
    }

    @Override
    public String nextLine() {
        String next = scanner.next();
        queue.add(next + "\n");
        return next;
    }

    public LocalDate nextLineParseToDateFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(scanner.next(), formatter);
        queue.add(date.toString() + "\n");
        return date;
    }

    @Override
    public double nextDouble() {
        double inputDouble = scanner.nextDouble();
        queue.add(String.valueOf(inputDouble) + "\n");
        return inputDouble;
    }

    @Override
    public int nextInt() {
        int inputInt = scanner.nextInt();
        queue.add(String.valueOf(inputInt) + "\n");
        return inputInt;
    }

    @Override
    public Queue<String> getQueue() {
        return null;
    }
}