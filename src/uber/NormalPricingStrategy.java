package uber;

public class NormalPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFare(double distanceKm) {
        return 50 + (distanceKm * 12);
    }
}
