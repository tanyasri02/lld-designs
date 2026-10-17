package uber;

public class Ride {
    private int id;
    private Location pickup;
    private Location drop;
    private Rider rider;
    private Driver driver;
    private RideStatus status;

    public Ride(int id, Location pickup, Location drop, Rider rider, RideStatus status){
        this.id = id;
        this.pickup = pickup;
        this.drop = drop;
        this.rider = rider;
        this.status = status;
        this.driver = null;
    }

    public int getId(){
        return id;
    }

    public Location getPickup(){
        return pickup;
    }

    public Location getDrop(){
        return drop;
    }

    public Rider getRider(){
        return rider;
    }

    public RideStatus getStatus() {
        return status;
    }

    public Driver getDriver(){
        return driver;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = RideStatus.DRIVER_ASSIGNED;
    }
}

