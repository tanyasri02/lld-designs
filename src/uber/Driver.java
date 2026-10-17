package uber;

import java.util.concurrent.atomic.AtomicReference;

public class Driver {
    private int id;
    private Vehicle vehicle;
    private String model;
    private AtomicReference<DriverStatus> status = new AtomicReference<>(DriverStatus.AVAILABLE);
    private Location location;

    public Driver(int id, Vehicle vehicle, String model, AtomicReference<DriverStatus> status, Location location){
        this.id = id;
        this.vehicle = vehicle;
        this.model = model;
        this.status = status;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public DriverStatus getStatus() {
        return status.get();
    }

    public Location getLocation() {
        return location;
    }

    public String getModel(){
        return model;
    }

    public boolean tryBooking(){
        return status.compareAndSet(DriverStatus.AVAILABLE, DriverStatus.BOOKED);
    }
}
