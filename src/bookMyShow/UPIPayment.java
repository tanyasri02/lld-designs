package bookMyShow;

import java.math.BigDecimal;

public class UPIPayment implements PaymentMethod {
    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println("Processing UPI payment: " + amount);
        return true;
    }
}
