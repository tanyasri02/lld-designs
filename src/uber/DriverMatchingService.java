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

    private double calculateDistance(Location driver, Location pickup){
        //todo : add the logic of geospatial
        return 0.0;
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

        for(Driver driver: nearByDrivers){
            Vehicle vehicle = driver.getVehicle();

            if(!eligibilityService.isEligible(vehicle, rideType)){
                return null;
            }

            if(driver.tryBooking()){
                return driver;
            }
        }
        return null;
    }
}
