package uber;

public class PricingService {

    private PricingStrategy pricingStrategy;

    public PricingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFare(double distanceKm) {
        return pricingStrategy.calculateFare(distanceKm);
    }
}
