package Multithreading_Questions._2_Online_Ticket_Booking;

public class RealisticTicketBookingApp {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking(2); // Only 2 seats available

        // Create multiple user threads
        Thread user1 = new Thread(new BookingThread(bookingSystem, "User1"));
        Thread user2 = new Thread(new BookingThread(bookingSystem, "User2"));
        Thread user3 = new Thread(new BookingThread(bookingSystem, "User3"));
        Thread user4 = new Thread(new BookingThread(bookingSystem, "User4"));

        // Start all users
        user1.start();
        user2.start();
        user3.start();
        user4.start();

        // Optionally interrupt a thread after some time to show interruption handling
        try {
            Thread.sleep(5000);
            user3.interrupt(); // Interrupt User3 if still waiting or holding
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
