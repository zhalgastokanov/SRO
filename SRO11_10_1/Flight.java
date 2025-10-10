package SRO.SRO11_10_1;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private int capacity;
    private List<Passenger> passengers;

    public Flight(String flightNumber, String departure, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public boolean addPassenger(Passenger p) {
        if (passengers.size() >= capacity) {
            System.out.println("Мест нет на рейсе " + flightNumber);
            return false;
        }
        passengers.add(p);
        return true;
    }

    public boolean removePassenger(Passenger p) {
        return passengers.remove(p);
    }

    @Override
    public String toString() {
        return "Рейс " + flightNumber + " [" + departure + " → " + destination + "], мест: " + capacity;
    }
}
