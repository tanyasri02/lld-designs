
package bookMyShow;

import java.math.BigDecimal;
import java.util.List;

public class BookingService {
    private final LockProvider lockProvider;
    private final PaymentService paymentService;

    public BookingService(LockProvider lockProvider, PaymentService paymentService) {
        this.lockProvider = lockProvider;
        this.paymentService = paymentService;
    }

    public Booking createBooking(int bookingId, int paymentId, User user, Show show, List<ShowSeat> selectedSeats, BigDecimal amount, PaymentMethod paymentMethod) {
        if (selectedSeats == null || selectedSeats.isEmpty()) {
            throw new IllegalArgumentException("Select at least one seat");
        }

        boolean locked = lockProvider.lockSeats(show, selectedSeats);

        if (!locked) {
            throw new IllegalStateException("One or more seats are unavailable");
        }

        Booking booking = new Booking(bookingId, user, show, selectedSeats, BookingStatus.PENDING);

        Payment payment = paymentService.processPayment(paymentId, booking, amount, paymentMethod);

        if (payment.getPaymentStatus() == PaymentStatus.SUCCESS) {
            booking.confirmBooking();
            for (ShowSeat seat : selectedSeats) {
                seat.setStatus(SeatStatus.BOOKED);
            }
        } else {
            booking.cancelBooking();
            lockProvider.releaseSeats(show, selectedSeats);
        }

        return booking;
    }
}
