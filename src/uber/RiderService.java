package uber;

public class RiderService {
    private DriverMatchingService driverMatchingService;

    public RiderService(DriverMatchingService driverMatchingService){
        this.driverMatchingService = driverMatchingService;
    }

    public Ride requestRide(Rider rider, Location pickup, Location destination, RideType rideType){
        Driver driver = driverMatchingService.findAndReserveDriver(pickup, rideType);

        if(driver == null){
            return null;
        }

        Ride ride = new Ride(generateRideId(), pickup, destination, rider, RideStatus.REQUESTED);

        ride.assignDriver(driver);
        return ride;
    }

    private int generateRideId(){
        return 1;
    }
}
