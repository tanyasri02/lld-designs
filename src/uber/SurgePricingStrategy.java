package uber;

public class SurgePricingStrategy implements PricingStrategy {

    private double surgeMultiplier;

    public SurgePricingStrategy(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }

    @Override
    public double calculateFare(double distanceKm) {
        double normalFare = 50 + (distanceKm * 12);
        return normalFare * surgeMultiplier;
    }
}
