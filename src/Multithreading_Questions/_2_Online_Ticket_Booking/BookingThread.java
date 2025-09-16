package Multithreading_Questions._2_Online_Ticket_Booking;

class BookingThread implements Runnable {
    private TicketBooking bookingSystem;
    private String userName;

    public BookingThread(TicketBooking bookingSystem, String userName) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
    }

    @Override
    public void run() {
        // Try booking a seat
        bookingSystem.bookTicket(userName);

        // Simulate holding the seat
        try {
            int holdTime = (int) (Math.random() * 3000) + 1000;
            System.out.println(userName + " is holding the seat for " + holdTime + " ms.");
            Thread.sleep(holdTime);
        } catch (InterruptedException e) {
            System.out.println(userName + " was interrupted while holding the seat.");
        }

        // Randomly decide whether to cancel normally or emergency cancel
        if (Math.random() > 0.7) {
            bookingSystem.emergencyCancel(userName);
        } else {
            bookingSystem.cancelSeat(userName);
        }
    }
}
