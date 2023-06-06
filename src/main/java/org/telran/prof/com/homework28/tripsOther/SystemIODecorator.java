package org.telran.prof.com.homework28.tripsOther;

import java.time.LocalDate;
import java.util.Queue;

public interface SystemIODecorator {

    void println(String outString);

    void println(Trip trip);

    String nextLine();

    double nextDouble();

    int nextInt();

    Queue<String> getQueue();

    LocalDate nextLineParseToDateFormat();

}
