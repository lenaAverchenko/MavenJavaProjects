package org.telran.prof.com.homework28.tripsOther;

import java.util.Comparator;

public class PriceComparator implements Comparator<Trip> {
    @Override
    public int compare(Trip o1, Trip o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
