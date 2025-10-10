package SRO.SRO11_10_1;

import java.util.*;

public class BookingSystem {
    private Map<String, Flight> flights = new HashMap<>();

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    public void bookTicket(Passenger p, String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            if (flight.addPassenger(p)) {
                System.out.println(p.getName() + " забронировал билет на " + flightNumber);
                p.addPoints(10); // бонусные баллы
            }
        } else {
            System.out.println("Рейс не найден");
        }
    }

    public void cancelTicket(Passenger p, String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null && flight.removePassenger(p)) {
            System.out.println(p.getName() + " отменил бронь на " + flightNumber);
        } else {
            System.out.println("Ошибка при отмене билета");
        }
    }

    public List<Passenger> getPassengers(String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            return flight.getPassengers();
        }
        return new ArrayList<>();
    }

    public List<Passenger> getTopPassengers(int n) {
        PriorityQueue<Passenger> pq = new PriorityQueue<>();
        for (Flight f : flights.values()) {
            pq.addAll(f.getPassengers());
        }
        List<Passenger> result = new ArrayList<>();
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            result.add(pq.poll());
        }
        return result;
    }

    public void sortPassengersByName(String flightNumber) {
        List<Passenger> list = getPassengers(flightNumber);
        list.sort(Comparator.comparing(Passenger::getName));
        System.out.println("\nПассажиры рейса " + flightNumber + " (по имени):");
        for (Passenger p : list) {
            System.out.println(p);
        }
    }

    public void sortPassengersByPoints(String flightNumber) {
        List<Passenger> list = getPassengers(flightNumber);
        list.sort(Comparator.comparingInt(Passenger::getLoyaltyPoints).reversed());
        System.out.println("\nПассажиры рейса " + flightNumber + " (по баллам):");
        for (Passenger p : list) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        Flight f1 = new Flight("KZ101", "Алматы", "Астана", 3);
        Flight f2 = new Flight("KZ202", "Астана", "Шымкент", 2);

        system.addFlight(f1);
        system.addFlight(f2);

        Passenger p1 = new Passenger(1, "Алия", "AB12345", 50);
        Passenger p2 = new Passenger(2, "Дамир", "CD67890", 70);
        Passenger p3 = new Passenger(3, "Ерлан", "EF11223", 30);
        Passenger p4 = new Passenger(4, "Бота", "GH33445", 90);

        system.bookTicket(p1, "KZ101");
        system.bookTicket(p2, "KZ101");
        system.bookTicket(p3, "KZ101");
        system.bookTicket(p4, "KZ101"); // лишний — не влезет

        system.sortPassengersByName("KZ101");
        system.sortPassengersByPoints("KZ101");

        System.out.println("\nТоп пассажиров по всем рейсам:");
        for (Passenger p : system.getTopPassengers(3)) {
            System.out.println(p);
        }

        system.cancelTicket(p2, "KZ101");
    }
}
