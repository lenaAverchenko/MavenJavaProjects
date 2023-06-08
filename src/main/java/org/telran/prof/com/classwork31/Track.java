package org.telran.prof.com.classwork31;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Track implements  Runnable{

    private int number;
    private String departure;
    private String destination;
    private String[] parcels;
    private Exchanger<String> exchanger;

    public Track(int number, String departure, String destination, String[] parcels, Exchanger<String> exchanger) {
        this.number = number;
        this.departure = departure;
        this.destination = destination;
        this.parcels = parcels;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            System.out.println("In truck " + number + " put " + parcels[0] + " and " + parcels[1]);
            System.out.println("Truck " + number + " start from " + departure + " to " + destination + "" +
                    " and will stop in point E");

            Thread.sleep(random.nextInt(3) * 1000L);
            System.out.println("Truck " + number + " arrived in point E");
            parcels[1] = exchanger.exchange(parcels[1]);
            System.out.println("In truck " + number + " put parcel from destination " + destination);
            Thread.sleep(random.nextInt(3) * 1000L);
            System.out.println("In truck " + number + " arrived in " + destination + " and delivered " + parcels[0] + " and "+
                    parcels[1]);

        } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
