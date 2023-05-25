package org.telran.prof.com.homework26.trips;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InformationBox {


    private List<Trip> trips;

    private List<String> sourceCities;

    private List<String> destinationCities;

    private double minPrice;

    private double maxPrice;

    private Scanner scanner;
    private Scanner scannerJustForTests;

    public InformationBox(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public void setScanner(Scanner scan) {
        this.scanner = scan;
    }

    @Override
    public String toString() {
        return "InformationBox{" +
                "trips=" + trips +
                '}';
    }

    public void setScannerJustForTests(Scanner scannerJustForTests) {
        this.scannerJustForTests = scannerJustForTests;
    }

    private void init() {
        sourceCities = trips.stream()
                .map(Trip::getSource)
                .distinct()
                .collect(Collectors.toList());
        destinationCities = trips.stream()
                .map(Trip::getDestination)
                .distinct()
                .collect(Collectors.toList());
        minPrice = trips.stream()
                .mapToDouble(Trip::getPrice)
                .min().orElse(0.0);
        maxPrice = trips.stream()
                .mapToDouble(Trip::getPrice)
                .max().orElse(0.0);
        scanner = new Scanner(System.in);
        scannerJustForTests = new Scanner(System.in);
    }

    public void getInformation() {
        init();

        while (true) {
            System.out.println("Pick the command: 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'");
            String command = scanner.next();
            switch (command) {
                case "A":
                    trips.forEach(System.out::println);
                    break;
                case "B":
                    trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice)).forEach(System.out::println);
                    break;
                case "C":
                    trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice).reversed()).forEach(System.out::println);
                    break;
                case "D":
                    double askedMinPrice = 0;
                    double askedMaxPrice = 0;
                    try {
                        System.out.println("Please, enter the minimum price for your trip in '00,00' or '000' format: ");
                        askedMinPrice = scanner.nextDouble();
                        System.out.println("Please, enter the maximum price for your trip in '00,00' or '000' format: ");
                        askedMaxPrice = scanner.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Wrong format of the price");
                    }
                    double finalAskedMinPrice = askedMinPrice;
                    double finalAskedMaxPrice = askedMaxPrice;
                    List<Trip> tripFromRange = getTripFromRange(finalAskedMinPrice, finalAskedMaxPrice);
                    if (tripFromRange.isEmpty()) {
                        System.out.println("There are no results for your request!");
                    } else {
                        tripFromRange.forEach(System.out::println);
                    }
                    break;
                case "E":
                    System.out.println("Please, enter the city to begin your trip with. You can pick one of the following:");
                    sourceCities.forEach(System.out::println);
                    getTripBySource(sourceCities).forEach(System.out::println);
                    break;
                case "F":
                    System.out.println("Please, enter the city to begin your trip. You can pick one of the following:");
                    destinationCities.forEach(System.out::println);
                    getTripByDestination(destinationCities).forEach(System.out::println);
                    break;
                case "G":
                    System.out.printf(("The amount of available trips is %d. \nThe prices are in the range from %.2f to %.2f, " +
                            "\nStarting from following cities: " + sourceCities + "\nto the following cities: " + destinationCities + "\n"), trips.size(), minPrice, maxPrice);
                    break;
                case "H":
                    System.out.println(getTripByDateRange());
                    break;
                case "I":
                    System.out.println(getTripByStartDateRangeInRadius());
                    break;
                case "J":
                    System.out.println(getTripByEndDateRangeInRadius());
                    break;
                default:
                    System.out.println("This command doesn't exist! Please, try again!");
                    continue;
            }

            System.out.println("Would you like to know more information? Y/N");
            String answer = scanner.next();
            if ("N".equals(answer)) break;
        }
        scanner.close();
    }

    public List<Trip> getTripByDestination(List<String> destinationCities) {
        String city = scanner.next();
        while (!destinationCities.contains(city)) {
            System.out.println("Pick the one of the following cities:");
            destinationCities.forEach(System.out::println);
            city = scanner.next();
        }
        String finalCity = city;
        //Проверять на вхождение города не нужно, этот код будет выполнен, только если город подойдет
        return trips.stream()
                .filter(t -> t.getDestination().equals(finalCity)).collect(Collectors.toList());
    }

    public List<Trip> getTripBySource(List<String> sourceCities) {
        String city = scanner.next();
        while (!sourceCities.contains(city)) {
            System.out.println("Pick the one of the following cities:");
            sourceCities.forEach(System.out::println);
            city = scanner.next();
        }
        String finalCity = city;
        //Проверять на вхождение города не нужно, этот код будет выполнен, только если город подойдет
        return trips.stream()
                .filter(t -> t.getSource().equals(finalCity)).collect(Collectors.toList());
    }

    public List<Trip> getTripFromRange(double askedMinPrice, double askedMaxPrice) {
        //меняю из-за теста для примера
//        double askedMinPrice = 0.0;
//        double askedMaxPrice = 0.0;
//        try {
//            System.out.println("Please, enter the minimum price for your trip in '00,00' or '000' format: ");
//            askedMinPrice = scanner.nextDouble();
//            System.out.println("Please, enter the maximum price for your trip in '00,00' or '000' format: ");
//            askedMaxPrice = scanner.nextDouble();
//        } catch (Exception e) {
//            System.out.println("Wrong format of the price");
//        }
//        double finalAskedMinPrice = askedMinPrice;
//        double finalAskedMaxPrice = askedMaxPrice;
        return trips.stream()
                .filter(t -> (t.getPrice() >= askedMinPrice && t.getPrice() <= askedMaxPrice))
                .collect(Collectors.toList());
    }

    public List<Trip> getTripByDateRange() {
        LocalDate leaving = LocalDate.now();
        LocalDate departure = LocalDate.now();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Please, enter the date of leaving (yyyy-mm-dd)");
            leaving = LocalDate.parse(scanner.next(), formatter);
            System.out.println("Please, enter the date of departure (yyyy-mm-dd)");
            departure = LocalDate.parse(scannerJustForTests.next(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            getTripByDateRange();
        }
        LocalDate finalLeaving = leaving;
        LocalDate finalDeparture = departure;
        return trips.stream().filter(tr -> tr.getStartDate().compareTo(finalLeaving) >= 0)
                .filter(tr -> tr.getReturnDate().compareTo(finalDeparture) <= 0)
                .collect(Collectors.toList());
    }

    public List<Trip> getTripByStartDateRangeInRadius() {
        LocalDate leaving = LocalDate.now();
        int radius = 0;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Please, enter the date of leaving (yyyy-mm-dd)");
            leaving = LocalDate.parse(scanner.next(), formatter);
            System.out.println("Please, enter the radius of days: ");
            radius = scannerJustForTests.nextInt();

        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            getTripByStartDateRangeInRadius();
        }
        LocalDate finalLeaving = leaving;
        int finalRadius = radius;
        return trips.stream()
                .filter(tr -> tr.getStartDate().compareTo(finalLeaving.plusDays(finalRadius)) <= 0)
                .filter(tr -> tr.getStartDate().compareTo(finalLeaving.minusDays(finalRadius)) >= 0)
                .collect(Collectors.toList());
    }

    public List<Trip> getTripByEndDateRangeInRadius() {
        LocalDate departure = LocalDate.now();
        int radius = 0;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Please, enter the date of departure (yyyy-mm-dd)");
            departure = LocalDate.parse(scanner.next(), formatter);
            System.out.println("Please, enter the radius of days: ");
            radius = scannerJustForTests.nextInt();

        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            getTripByEndDateRangeInRadius();
        }
        LocalDate finalDepartureString = departure;

        int finalRadius = radius;
        return trips.stream()
                .filter(tr -> tr.getReturnDate().compareTo(finalDepartureString.plusDays(finalRadius)) <= 0)
                .filter(tr -> tr.getReturnDate().compareTo(finalDepartureString.minusDays(finalRadius)) >= 0)
                .collect(Collectors.toList());
    }

}