package org.telran.prof.com.homework26.trips;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InformationBoxTest {
    static List<Trip> trips = new ArrayList<>();
    InformationBox informationBox = new InformationBox(trips);

    @BeforeAll
    static void init() {
        trips = Arrays.asList(
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
    }

    @Test
    void getTripByDestination() {
        String destination = "Gdansk";
        Scanner newScanner = new Scanner(destination);
        informationBox.setScanner(newScanner);
        long count = informationBox.getTripByDestination(informationBox.getTrips()
                .stream().map(Trip::getDestination).collect(Collectors.toList())).size();
        Assertions.assertEquals(2L, count);
    }

    @Test
    void getTripBySource() {
        String source = "Berlin";
        Scanner newScanner = new Scanner(source);
        informationBox.setScanner(newScanner);
        long count = informationBox.getTripBySource(informationBox.getTrips()
                .stream().map(Trip::getSource).collect(Collectors.toList())).size();
        Assertions.assertEquals(3L, count);
    }

    @Test
    void getTripFromRange() {
        //тут 2 раза запрос сканнера
        // пришлось сделать основной метод громоздким - сделала так только с одним примером.
        // чтобы покрыть этот метод тестом, нужно в него что-то передать, либо сделать 2 независимых сканнера
        // Вариант первый:
        long count = informationBox.getTripFromRange(50, 200).size();
        Assertions.assertEquals(2, count);

    }

    @Test
    void getTripByDateRange() {
        //тут 2 раза запрос сканнера - добавила тестово еще один сканнер
        // я думаю, это неверный подход. Правильнее было бы сделать, как с getTripFromRange()
        // и тесты в данном случае получаются не короткими
        // Но для проверки оставлю оба варианта, оба рабочие. И оба засоряют основную программу)
        // Только предыдущий - делает громоздким основной метод, потому как все сканнеры переходят в него, а в методах
        // дополнительных передаются параметры уже
        // а в текущем варианте - лишний сканнер, плюс сеттер позволяет его поменять и считать данные из любого места.

        String date = "2023-01-01";
        Scanner newScanner = new Scanner(date);
        informationBox.setScanner(newScanner);
        String date1 = "2023-05-01";
        Scanner newScannerAnother = new Scanner(date1);
        informationBox.setScannerJustForTests(newScannerAnother);
        long count = informationBox.getTripByDateRange().size();
        Assertions.assertEquals(4, count);

    }

    @Test
    void getTripByStartDateRangeInRadius() {
        //тут 2 раза запрос сканнера
        String date = "2023-01-01";
        Scanner newScanner = new Scanner(date);
        informationBox.setScanner(newScanner);
        int radius = 60;
        Scanner newScannerAnother = new Scanner(String.valueOf(radius));
        informationBox.setScannerJustForTests(newScannerAnother);
        long count = informationBox.getTripByStartDateRangeInRadius().size();
        Assertions.assertEquals(2, count);
    }

    @Test
    void getTripByEndDateRangeInRadius() {
        //тут 2 раза запрос сканнера
        String date = "2023-05-01";
        Scanner newScanner = new Scanner(date);
        informationBox.setScanner(newScanner);
        int radius = 60;
        Scanner newScannerAnother = new Scanner(String.valueOf(radius));
        informationBox.setScannerJustForTests(newScannerAnother);
        long count = informationBox.getTripByEndDateRangeInRadius().size();
        Assertions.assertEquals(6, count);
    }
}