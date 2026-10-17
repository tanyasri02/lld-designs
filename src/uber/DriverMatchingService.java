package uber;

import java.util.ArrayList;
import java.util.List;

public class DriverMatchingService {
    private List<Driver> drivers;
    private RideEligibilityService eligibilityService;

    public DriverMatchingService(List<Driver> drivers, RideEligibilityService eligibilityService){
        this.drivers = drivers;
        this.eligibilityService = eligibilityService;
    }


    private double calculateDistance(Location driver, Location pickup) {
        double earthRadiusKm = 6371.0;

        double lat1 = Math.toRadians(driver.getLatitude());
        double lat2 = Math.toRadians(pickup.getLatitude());
        double deltaLat = lat2 - lat1;

        double long1 = Math.toRadians(driver.getLongitude());
        double long2 = Math.toRadians(pickup.getLongitude());
        double deltaLon = long2 - long1;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadiusKm * c;
    }


    public List<Driver> findNearByDrivers(Location pickup){
        List<Driver> nearByDrivers = new ArrayList<>();

        double radiusKm = 5.0;

        for(Driver driver : drivers){
            if(driver.getStatus() != DriverStatus.AVAILABLE){
                continue;
            }

            double distance = calculateDistance(driver.getLocation(), pickup);

            if(distance <= radiusKm) {
                nearByDrivers.add(driver);
            }
        }
        return nearByDrivers;
    }


    public Driver findAndReserveDriver(Location pickup, RideType rideType){
        List<Driver> nearByDrivers = findNearByDrivers(pickup);
        System.out.println("Nearby drivers found: " + nearByDrivers.size());

        for(Driver driver: nearByDrivers){
            Vehicle vehicle = driver.getVehicle();

            if(!eligibilityService.isEligible(vehicle, rideType)){
                continue;
            }

            if(driver.tryBooking()){
                return driver;
            }
        }
        return null;
    }
}
