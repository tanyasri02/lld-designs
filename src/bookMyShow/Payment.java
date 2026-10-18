
package bookMyShow;
import java.math.BigDecimal;

public class Payment {
    private int id;
    private Booking booking;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    public Payment(int id, Booking booking, BigDecimal amount, PaymentStatus paymentStatus){
        this.id = id;
        this.booking = booking;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void markSuccessful() {
        paymentStatus = PaymentStatus.SUCCESS;
    }


    public void markFailed() {
        paymentStatus = PaymentStatus.FAILED;
    }
}
