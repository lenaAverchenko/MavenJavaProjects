package org.telran.prof.com.homework28.tripsOther;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TripApp {
    public static void main(String[] args) throws InterruptedException, IOException {


        List<Trip> trips = Arrays.asList(
                new Trip("Berlin", "Gdansk", "06:30", 123.55, LocalDate.of(2023, 4, 12), LocalDate.of(2023, 4, 15)),
                new Trip("Berlin", "Warsaw", "05:00", 299.99, LocalDate.of(2023, 5, 22), LocalDate.of(2023, 5, 28)),
                new Trip("Luban", "Wroclaw", "04:15", 50.45, LocalDate.of(2023, 6, 17), LocalDate.of(2023, 6, 29)),
                new Trip("Vienna", "Gdansk", "12:00", 500.00, LocalDate.of(2023, 2, 15), LocalDate.of(2023, 2, 20)),
                new Trip("Gdansk", "Praha", "09:45", 425.00, LocalDate.of(2023, 5, 23), LocalDate.of(2023, 6, 1)),
                new Trip("Berlin", "Drezden", "00:20", 20.50, LocalDate.of(2023, 4, 23), LocalDate.of(2023, 4, 26)),
                new Trip("Wroclaw", "Praha", "15:00", 250.00, LocalDate.of(2023, 10, 19), LocalDate.of(2023, 10, 23)),
                new Trip("London", "Wroclaw", "22:50", 789.99, LocalDate.of(2023, 12, 5), LocalDate.of(2023, 12, 30)),
                new Trip("Toronto", "Frankfurt", "13:00", 1250.00, LocalDate.of(2023, 9, 8), LocalDate.of(2023, 9, 25)),
                new Trip("Praha", "Vienna", "08:00", 510.00, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 24)),
                new Trip("Frankfurt", "Wroclaw", "18:00", 700.80, LocalDate.of(2023, 6, 8), LocalDate.of(2023, 6, 27))
        );

        InformationBox informationBox = new InformationBox(trips);
        informationBox.run();
    }
}
