package Multithreading_Questions._10_Simulate_Ticket_Booking_System;

public class TicketBookingSimulation {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);

        // Create multiple threads simulating users trying to book seats
        Thread user1 = new Thread(new BookingTask(system, 3, "User1"));
        Thread user2 = new Thread(new BookingTask(system, 3, "User2"));
        Thread user3 = new Thread(new BookingTask(system, 5, "User3"));
        Thread user4 = new Thread(new BookingTask(system, 7, "User4"));
        Thread user5 = new Thread(new BookingTask(system, 5, "User5"));

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
    }
}
