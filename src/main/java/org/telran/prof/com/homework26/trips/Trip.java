package org.telran.prof.com.homework26.trips;

import java.time.LocalDate;

public class Trip {
    private String source;
    private String destination;
    private String hours;
    private double price;
    private LocalDate startDate;
    private LocalDate returnDate;

    public Trip(String source, String destination, String hours, double price, LocalDate startDate, LocalDate returnDate) {
        this.source = source;
        this.destination = destination;
        this.hours = hours;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", hours='" + hours + '\'' +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
