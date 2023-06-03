package org.telran.prof.com.homework28.tripsOther;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class InformationBox {

    private List<Trip> trips;

    private List<String> sourceCities;

    private List<String> destinationCities;

    private double minPrice;

    private double maxPrice;

    private Scanner scanner;
    private String command;
    private Logger logger;

    private Queue<String> bufferedQueue = new ArrayDeque<>();
    private List<Trip> currentTrips;

    public Scanner getScanner() {
        return scanner;
    }


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
    }


    public Queue<String> getBufferedQueue() {
        return bufferedQueue;
    }

    public void setBufferedQueue(Queue<String> bufferedQueue) {
        this.bufferedQueue = bufferedQueue;
    }

    public void run() throws InterruptedException {
        init();
        try {
            logger = new Logger("C:\\JavaProjects\\Java\\Homework\\January\\maventelran\\src\\main\\java\\org\\telran\\prof\\com\\homework28\\tripsOther\\res.txt");
            logger.setInformationBox(this);
        } catch (IOException e) {
            System.out.println("Logger has failed");
            ;
        }
        Thread thread = new Thread(logger);
        thread.start();
        while (!"Q".equals(command)) {
            System.out.println("Pick the command: 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'Q'");
            command = scanner.next();
            bufferedQueue.add(command + "\n");
            switch (command) {
                case "A":
                    currentTrips = trips.stream().collect(Collectors.toList());
                    currentTrips.forEach(System.out::println);
                    break;
                case "B":
                    currentTrips = trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice)).collect(Collectors.toList());
                    currentTrips.forEach(System.out::println);
                    break;
                case "C":
                    currentTrips = trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice).reversed()).collect(Collectors.toList());
                    currentTrips.forEach(System.out::println);
                    break;
                case "D":
                    double askedMinPrice = 0;
                    double askedMaxPrice = 0;
                    try {
                        String askedMin = "Please, enter the minimum price for your trip in '00,00' or '000' format: ";
                        System.out.println(askedMin);
                        bufferedQueue.add(askedMin);
                        askedMinPrice = scanner.nextDouble();
                        bufferedQueue.add(Double.toString(askedMinPrice));
                        String askedMax = "Please, enter the maximum price for your trip in '00,00' or '000' format: ";
                        System.out.println(askedMax);
                        bufferedQueue.add(askedMax);
                        askedMaxPrice = scanner.nextDouble();
                        bufferedQueue.add(Double.toString(askedMaxPrice));
                    } catch (Exception e) {
                        System.out.println("Wrong format of the price");
                        bufferedQueue.add("Wrong format of the price");
                    }
                    double finalAskedMinPrice = askedMinPrice;
                    double finalAskedMaxPrice = askedMaxPrice;
                    currentTrips = getTripFromRange(finalAskedMinPrice, finalAskedMaxPrice);
                    if (currentTrips.isEmpty()) {
                        bufferedQueue.add("There are no results for your request!\n");
                        System.out.println("There are no results for your request!");
                    } else {
                        currentTrips.forEach(System.out::println);
                    }
                    break;
                case "E":
                    System.out.println("Please, enter the city to begin your trip with. You can pick one of the following:");
                    bufferedQueue.add("Please, enter the city to begin your trip with. You can pick one of the following:" +
                            sourceCities.stream().toList());
                    sourceCities.forEach(System.out::println);
                    currentTrips = getTripBySource(sourceCities).stream().collect(Collectors.toList());
                    currentTrips.forEach(System.out::println);
                    break;
                case "F":
                    System.out.println("Please, enter the city to begin your trip. You can pick one of the following:");
                    destinationCities.forEach(System.out::println);
                    currentTrips = getTripByDestination(destinationCities).stream().collect(Collectors.toList());
                    currentTrips.forEach(System.out::println);
                    break;
                case "G":
                    String str = "The amount of available trips is " + trips.size() + ". \nThe prices are in the range from " + minPrice + " to " + maxPrice +
                            "\nStarting from following cities: " + sourceCities + "\nto the following cities: " + destinationCities + "\n";
                    bufferedQueue.add(str + "\n");
                    System.out.printf(str);
                    break;
                case "H":
                    currentTrips = getTripByDateRange();
                    System.out.println(currentTrips);
                    break;
                case "I":
                    currentTrips = getTripByStartDateRangeInRadius();
                    System.out.println(currentTrips);
                    break;
                case "J":
                    currentTrips = getTripByEndDateRangeInRadius();
                    System.out.println(currentTrips);
                    break;
                case "Q":
                    bufferedQueue.add("Q\n");
                    scanner.close();
                    thread.interrupt();
                    break;
                default:
                    System.out.println("This command doesn't exist! Please, try again!");
                    continue;
            }
            bufferedQueue.add(currentTrips.toString() + "\n");
        }
    }

    public List<Trip> getTripByDestination(List<String> destinationCities) {
        String city = scanner.next();
        bufferedQueue.add("Picked city: " + city + "\n");
        while (!destinationCities.contains(city)) {
            System.out.println("Pick the one of the following cities:\n");
            destinationCities.forEach(System.out::println);
            bufferedQueue.add("Pick the one of the following cities: \n" + destinationCities.stream().toList());
            city = scanner.next();
            bufferedQueue.add("Picked city: " + city + "\n");
        }
        String finalCity = city;
        return trips.stream()
                .filter(t -> t.getDestination().equals(finalCity)).collect(Collectors.toList());
    }

    public List<Trip> getTripBySource(List<String> sourceCities) {
        String city = scanner.next();
        bufferedQueue.add("Picked city: " + city + "\n");
        while (!sourceCities.contains(city)) {
            System.out.println("Pick the one of the following cities:");
            bufferedQueue.add("Pick the one of the following cities: " + sourceCities.stream().toList() + "\n");
            sourceCities.forEach(System.out::println);
            city = scanner.next();
            bufferedQueue.add("Picked city: " + city + "\n");
        }
        String finalCity = city;
        return trips.stream()
                .filter(t -> t.getSource().equals(finalCity)).collect(Collectors.toList());
    }

    public List<Trip> getTripFromRange(double askedMinPrice, double askedMaxPrice) {
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
            bufferedQueue.add("Please, enter the date of leaving (yyyy-mm-dd)" + "\n");
            leaving = LocalDate.parse(scanner.next(), formatter);
            bufferedQueue.add(leaving.toString() + "\n");
            System.out.println("Please, enter the date of departure (yyyy-mm-dd)");
            bufferedQueue.add("Please, enter the date of departure (yyyy-mm-dd)" + "\n");
            departure = LocalDate.parse(scanner.next(), formatter);
            bufferedQueue.add(departure.toString() + "\n");
        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            bufferedQueue.add("The wrong date format. Try again!" + "\n");
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
            bufferedQueue.add("Please, enter the date of leaving (yyyy-mm-dd)" + "\n");
            leaving = LocalDate.parse(scanner.next(), formatter);
            bufferedQueue.add(leaving.toString() + "\n");
            System.out.println("Please, enter the radius of days: ");
            bufferedQueue.add("Please, enter the radius of days: " + "\n");
            radius = scanner.nextInt();
            bufferedQueue.add(Integer.toString(radius) + "\n");

        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            bufferedQueue.add("The wrong date format. Try again!" + "\n");
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
            bufferedQueue.add("Please, enter the date of departure (yyyy-mm-dd)" + "\n");
            departure = LocalDate.parse(scanner.next(), formatter);
            bufferedQueue.add(departure.toString() + "\n");
            System.out.println("Please, enter the radius of days: ");
            bufferedQueue.add("Please, enter the radius of days: " + "\n");
            radius = scanner.nextInt();
            bufferedQueue.add(Integer.toString(radius) + "\n");

        } catch (DateTimeParseException e) {
            System.out.println("The wrong date format. Try again!");
            bufferedQueue.add("The wrong date format. Try again!" + "\n");
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