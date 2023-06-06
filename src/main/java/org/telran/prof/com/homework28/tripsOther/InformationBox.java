package org.telran.prof.com.homework28.tripsOther;

import java.io.IOException;
import java.time.LocalDate;
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
    private SystemIODecoratorImpl systemIODecorator;
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
        systemIODecorator = new SystemIODecoratorImpl(new Scanner(System.in), bufferedQueue);
    }


    public Queue<String> getBufferedQueue() {
        return bufferedQueue;
    }

    public void setBufferedQueue(Queue<String> bufferedQueue) {
        this.bufferedQueue = bufferedQueue;
    }


    public SystemIODecoratorImpl getSystemIODecorator() {
        return systemIODecorator;
    }

    public void setSystemIODecorator(SystemIODecoratorImpl systemIODecorator) {
        this.systemIODecorator = systemIODecorator;
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
            command = systemIODecorator.nextLine();
            switch (command) {
                case "A":
                    currentTrips = trips.stream().collect(Collectors.toList());
                    currentTrips.forEach(tr -> systemIODecorator.println(tr));
                    break;
                case "B":
                    currentTrips = trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice)).collect(Collectors.toList());
                    currentTrips.forEach(tr -> systemIODecorator.println(tr));
                    break;
                case "C":
                    currentTrips = trips.stream().sorted(Comparator.comparingDouble(Trip::getPrice).reversed()).collect(Collectors.toList());
                    currentTrips.forEach(tr -> systemIODecorator.println(tr));
                    break;
                case "D":
                    double askedMinPrice = 0;
                    double askedMaxPrice = 0;
                    try {
                        systemIODecorator.println("Please, enter the minimum price for your trip in '00,00' or '000' format: ");
                        askedMinPrice = systemIODecorator.nextDouble();
                        systemIODecorator.println("Please, enter the minimum price for your trip in '00,00' or '000' format: ");
                        askedMaxPrice = systemIODecorator.nextDouble();
                    } catch (Exception e) {
                        systemIODecorator.println("Wrong format of the price");
                    }
                    double finalAskedMinPrice = askedMinPrice;
                    double finalAskedMaxPrice = askedMaxPrice;
                    currentTrips = getTripFromRange(finalAskedMinPrice, finalAskedMaxPrice);
                    if (currentTrips.isEmpty()) {
                        systemIODecorator.println("There are no results for your request!");
                    } else {
                        currentTrips.forEach(tr -> systemIODecorator.println(tr));
                    }
                    break;
                case "E":
                    systemIODecorator.println("Please, enter the city to begin your trip with. You can pick one of the following: \n"
                            + sourceCities.stream().toList());
                    currentTrips = getTripBySource(sourceCities).stream().collect(Collectors.toList());
                    currentTrips.forEach(trip -> systemIODecorator.println(trip));
                    break;
                case "F":
                    systemIODecorator.println("Please, enter the city to begin your trip. You can pick one of the following: \n"
                            + destinationCities.stream().toList());
                    currentTrips = getTripByDestination(destinationCities).stream().collect(Collectors.toList());
                    currentTrips.forEach(trip -> systemIODecorator.println(trip));
                    break;
                case "G":
                    systemIODecorator.println("The amount of available trips is " + trips.size() + ". \nThe prices are in the range from " + minPrice + " to " + maxPrice +
                            "\nStarting from following cities: " + sourceCities + "\nto the following cities: " + destinationCities + "\n");
                    break;
                case "H":
                    currentTrips = getTripByDateRange();
                    currentTrips.forEach(trip -> systemIODecorator.println(trip));
                    break;
                case "I":
                    currentTrips = getTripByStartDateRangeInRadius();
                    currentTrips.forEach(trip -> systemIODecorator.println(trip));
                    break;
                case "J":
                    currentTrips = getTripByEndDateRangeInRadius();
                    currentTrips.forEach(trip -> systemIODecorator.println(trip));
                    break;
                case "Q":
                    bufferedQueue.add("Q\n");
                    systemIODecorator.getScanner().close();
                    thread.interrupt();
                    break;
                default:
                    System.out.println("This command doesn't exist! Please, try again!");
                    systemIODecorator.println("This command doesn't exist! Please, try again!");
                    continue;
            }
        }
    }

    public List<Trip> getTripByDestination(List<String> destinationCities) {
        String city = systemIODecorator.nextLine();
        while (!destinationCities.contains(city)) {
            bufferedQueue.add("Pick the one of the following cities: \n" + destinationCities.stream().toList());
            systemIODecorator.println("Pick the one of the following cities:\n" + destinationCities.stream().toList());
            city = systemIODecorator.nextLine();
        }
        String finalCity = city;
        return trips.stream()
                .filter(t -> t.getDestination().equals(finalCity)).collect(Collectors.toList());
    }

    public List<Trip> getTripBySource(List<String> sourceCities) {
        String city = systemIODecorator.nextLine();
        while (!sourceCities.contains(city)) {
            systemIODecorator.println("Pick the one of the following cities: " + sourceCities.stream().toList());
            city = systemIODecorator.nextLine();
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
            systemIODecorator.println("Please, enter the date of leaving (yyyy-mm-dd)");
            leaving = systemIODecorator.nextLineParseToDateFormat();
            systemIODecorator.println("Please, enter the date of departure (yyyy-mm-dd)");
            departure = systemIODecorator.nextLineParseToDateFormat();
        } catch (DateTimeParseException e) {
            systemIODecorator.println("The wrong date format. Try again!");
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
            systemIODecorator.println("Please, enter the date of leaving (yyyy-mm-dd)");
            leaving = systemIODecorator.nextLineParseToDateFormat();
            systemIODecorator.println("Please, enter the radius of days: ");
            radius = systemIODecorator.nextInt();

        } catch (DateTimeParseException e) {
            systemIODecorator.println("The wrong date format. Try again!");
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
            systemIODecorator.println("Please, enter the date of departure (yyyy-mm-dd)");
            departure = systemIODecorator.nextLineParseToDateFormat();
            systemIODecorator.println("Please, enter the radius of days: ");
            radius = systemIODecorator.nextInt();

        } catch (DateTimeParseException e) {
            systemIODecorator.println("The wrong date format. Try again!");
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