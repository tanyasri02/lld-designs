
package bookMyShow;

import java.math.BigDecimal;

public class PaymentService {

    public Payment processPayment(int paymentId, Booking booking, BigDecimal amount, PaymentMethod paymentMethod) {

        Payment payment = new Payment(paymentId, booking, amount, PaymentStatus.PENDING);

        boolean successful = paymentMethod.pay(amount);

        if (successful) {
            payment.markSuccessful();
        } else {
            payment.markFailed();
        }

        return payment;
    }
}

