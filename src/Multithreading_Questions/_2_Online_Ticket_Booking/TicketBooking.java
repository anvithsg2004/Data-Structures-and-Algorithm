package Multithreading_Questions._2_Online_Ticket_Booking;

public class TicketBooking {

    public int availableSeats;

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String user) {
        System.out.println(user + " is trying to book a seat.");

        while (availableSeats <= 0) {
            System.out.println(user + " waiting for available seats...");
            try {
                wait();
            } catch (Exception e) {
                System.out.println(user + " was interrupted while waiting.");
                return;
            }
        }

        availableSeats--;
        System.out.println(user + " successfully booked a seat. Seats left: " + availableSeats);
    }

    public synchronized void cancelSeat(String user) {
        availableSeats++;
        System.out.println(user + " canceled their booking. Seats available now: " + availableSeats);

        notify();
    }

    public synchronized void emergencyCancel(String user) {
        availableSeats++;
        System.out.println(user + " performed emergency cancellation! Seats available: " + availableSeats);

        notifyAll();
    }

    public synchronized void printStatus() {
        System.out.println("Current available seats: " + availableSeats);
    }

}
