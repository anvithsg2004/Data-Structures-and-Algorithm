package Multithreading_Questions._10_Simulate_Ticket_Booking_System;

public class BookingTask implements Runnable {

    public TicketBookingSystem ticketBookingSystem;
    public int seatNumber;
    public String userName;

    public BookingTask(TicketBookingSystem ticketBookingSystem, int seatNumber, String userName) {
        this.ticketBookingSystem = ticketBookingSystem;
        this.seatNumber = seatNumber;
        this.userName = userName;
    }

    @Override
    public void run() {
        ticketBookingSystem.bookSeat(seatNumber, userName);
    }
}
