package uber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Location driverLocation = new Location(12.9716, 77.5946);
        Location riderLocation = new Location(12.9750, 77.5990);
        Location destination = new Location(12.9900, 77.6100);

        Vehicle vehicle = new Vehicle(101, "KA01AB1234", "Sedan", 4);

        Driver driver = new Driver(1, vehicle, new AtomicReference<>(DriverStatus.AVAILABLE), driverLocation);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver);

        RideEligibilityService eligibilityService = new RideEligibilityService();
        DriverMatchingService matchingService = new DriverMatchingService(drivers, eligibilityService);
        RiderService riderService = new RiderService(matchingService);

        Rider rider = new Rider(201, "Tanya", riderLocation);
        Ride ride = riderService.requestRide(
                rider,
                riderLocation,
                destination,
                RideType.UBER_GO
        );

        if (ride != null) {
            System.out.println("Ride ID: " + ride.getId());
            System.out.println("Ride Status: " + ride.getStatus());
            System.out.println("Assigned Driver: " + ride.getDriver().getId());
        } else {
            System.out.println("No eligible drivers available.");
        }
    }
}
