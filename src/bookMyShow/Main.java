
package bookMyShow;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie(1, "Interstellar");
        Screen screen = new Screen(101, 1);

        Show show = new Show(201, movie, screen, LocalDateTime.of(2026, 10, 20, 18, 0), LocalDateTime.of(2026, 10, 20, 21, 0));

        Seat seat = new Seat(1, SeatType.REGULAR, "A1");
        ShowSeat showSeat = new ShowSeat(show, seat, SeatStatus.AVAILABLE);

        User user = new User(1, "Tanya", "tanya@example.com");

        LockProvider lockProvider = new LockProvider();
        PaymentService paymentService = new PaymentService();
        BookingService bookingService = new BookingService(lockProvider, paymentService);

        PaymentMethod paymentMethod = new UPIPayment();
        Booking booking = bookingService.createBooking(1, 101, user, show, List.of(showSeat), new BigDecimal("250.00"), paymentMethod);

        System.out.println("Booking ID: " + booking.getId());
        System.out.println("Booking Status: " + booking.getBookingStatus());
    }
}

