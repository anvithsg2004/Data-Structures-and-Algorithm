package Multithreading_Questions._10_Simulate_Ticket_Booking_System;

import java.util.*;

public class TicketBookingSystem {

    Map<Integer, Boolean> seats = new HashMap<>();

    public TicketBookingSystem(int totalSeats) {
        for (int i = 0; i < totalSeats; i++) {
            seats.put(i, false);
        }
    }

    public synchronized boolean bookSeat(int seatNumber, String userName) {

        if (!seats.containsKey(seatNumber)) {
            System.out.println("Seat " + seatNumber + " does not exist.");
            return false;
        }

        if (seats.get(seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already booked by someone else.");
            return false;
        }

        // Book the seat
        seats.put(seatNumber, true);
        System.out.println(userName + " successfully booked seat " + seatNumber);
        return true;
    }

    public synchronized List<Integer> getAvailableSeats() {
        List<Integer> availableSeats = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> mp : seats.entrySet()) {

            Integer seatNumber = mp.getKey();
            Boolean isItAvailable = mp.getValue();

            if (!isItAvailable) {
                availableSeats.add(seatNumber);
            }

        }

        return availableSeats;
    }
}
