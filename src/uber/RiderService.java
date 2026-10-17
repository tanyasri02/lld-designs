package uber;

import java.util.concurrent.atomic.AtomicInteger;

public class RiderService {
    private final DriverMatchingService driverMatchingService;
    private final AtomicInteger rideIdGenerator = new AtomicInteger(0);

    public RiderService(DriverMatchingService driverMatchingService){
        this.driverMatchingService = driverMatchingService;
    }

    public Ride requestRide(Rider rider, Location pickup, Location destination, RideType rideType){
        Driver driver = driverMatchingService.findAndReserveDriver(pickup, rideType);
        System.out.println("Requested ride type: " + rideType);
        System.out.println("Matched driver: " + driver);

        if(driver == null){
            return null;
        }

        Ride ride = new Ride(generateRideId(), pickup, destination, rider, RideStatus.REQUESTED);

        ride.assignDriver(driver);
        return ride;
    }

    private int generateRideId(){
        return rideIdGenerator.incrementAndGet();
    }
}
