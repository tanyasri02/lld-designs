package uber;

public class RideEligibilityService {

    public boolean isEligible(Vehicle vehicle, RideType rideType) {
        if(vehicle == null || rideType == null){
            return false;
        }

        switch (rideType){
            case UBER_GO:
                return vehicle.getSeatingCapacity() >= 4;
            case UBER_XL:
                return  vehicle.getSeatingCapacity() >= 6;
            case UBER_PREMIUM:
                return vehicle.getSeatingCapacity() >= 8;
            default:
                return false;
        }
    }
}
